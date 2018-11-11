package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice33;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.*;

import java.util.*;

abstract class DelayedGreenhouseTask implements Delayed, Runnable {
    private long delayTime; // in MILLISECONDS
    private long trigger; // in NANOSECONDS

    DelayedGreenhouseTask() {
        delayTime = 0;
        trigger = System.nanoTime();
    }

    DelayedGreenhouseTask(long d) {
        delayTime = d;
        trigger = System.nanoTime() + NANOSECONDS.convert(delayTime, MILLISECONDS);
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    public int compareTo(Delayed d) {
        DelayedGreenhouseTask that = (DelayedGreenhouseTask) d;
        if (trigger < that.trigger) {
            return -1;
        }
        if (trigger > that.trigger) {
            return 1;
        }
        return 0;
    }

    // to be implemented by subclasses:
    abstract public DelayedGreenhouseTask create(long d);

    abstract public void run();
}

class GreenhouseController {
    private volatile boolean light = false;
    //    private volatile boolean water = false;
    //    private String thermostat = "Day";
    DelayQueue<DelayedGreenhouseTask> tasks = new DelayQueue<>();

    //    public synchronized String getThermostat()  {
    //        return thermostat;
    //    }
    //    public synchronized void setThermostat(String value) {
    //        thermostat = value;
    //    }
    class LightOn extends DelayedGreenhouseTask {
        public LightOn() {
            super();
        }

        public LightOn(long delayTime) {
            super(delayTime);
        }

        public LightOn create(long d) { // allows repetition
            return new LightOn(d);
        }

        public void run() {
            if (!light) {
                System.out.println("Turning on lights");
                light = true;
            }
        }
    }

    class LightOff extends DelayedGreenhouseTask {
        public LightOff() {
            super();
        }

        public LightOff(long delayTime) {
            super(delayTime);
        }

        public LightOff create(long d) {
            return new LightOff(d);
        }

        public void run() {
            if (light) {
                System.out.println("Turning off lights");
                light = false;
            }
        }
    }

    class WaterOn extends DelayedGreenhouseTask {
        public WaterOn() {
            super();
        }

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        public WaterOn create(long d) { // allows repetition
            return new WaterOn(d);
        }

        public void run() {
            // Hardware control here
            System.out.println("Turning greenhouse water on");
            //            water = true;
        }
    }

    class WaterOff extends DelayedGreenhouseTask {
        public WaterOff() {
            super();
        }

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        public WaterOff create(long d) {
            return new WaterOff(d);
        }

        public void run() {
            // Hardware control here
            System.out.println("Turning greenhouse water off");
            //            water = false;
        }
    }

    class ThermostatNight extends DelayedGreenhouseTask {
        public ThermostatNight() {
            super();
        }

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        public ThermostatNight create(long d) {
            return new ThermostatNight(d);
        }

        public void run() {
            // Hardware control here
            System.out.println("Thermostat to night setting");
            //            setThermostat("Night");
        }
    }

    class ThermostatDay extends DelayedGreenhouseTask {
        public ThermostatDay() {
            super();
        }

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        public ThermostatDay create(long d) {
            return new ThermostatDay(d);
        }

        public void run() {
            // Hardware control here
            System.out.println("Thermostat to day setting");
            //            setThermostat("Day");
        }
    }

    class Bell extends DelayedGreenhouseTask {
        public Bell() {
            super();
        }

        public Bell(long delayTime) {
            super(delayTime);
        }

        public Bell create(long d) {
            return new Bell(d);
        }

        public void run() {
            System.out.println("Bing!");
        }
    }

    // New feature: data collection
    private static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        DataPoint(Calendar d, float temp, float hum) {
            time = d;
            temperature = temp;
            humidity = hum;
        }

        public String toString() {
            return time.getTime() + String.format(" temperature: %1$.1f humidity: %2$.2f", temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    { // Adjust date to the half hour
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 0);
    }

    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    private List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());

    class CollectData extends DelayedGreenhouseTask {
        CollectData() {
            super();
        }

        CollectData(long delayTime) {
            super(delayTime);
        }

        public CollectData create(long d) {
            return new CollectData(d);
        }

        public void run() {
            System.out.println("Collecting data");
            synchronized (GreenhouseController.this) {
                // Pretend the interval is longer that it is:
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
                // One in 5 chance of reversing the direction:
                if (rand.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                // Store previous value:
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4) {
                    humidityDirection = -humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
                // Calendar must be cloned, otherwise al
                // DataPoints hold references to the same lastTime.
                // For a basic object like Calendar, clone() is OK.
                data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }

    class StopController extends DelayedGreenhouseTask {
        private ExecutorService exec;

        StopController(long delay, ExecutorService e) {
            super(delay);
            exec = e;
        }

        public StopController create(long delay) {
            return new StopController(delay, Executors.newCachedThreadPool());
        }

        public void run() {
            System.out.println("Calling shutdownNow()");
            exec.shutdownNow();
            // need new Thread since others are shut down:
            new Thread() {
                public void run() {
                    for (DataPoint d : data) {
                        System.out.println(d);
                    }
                }
            }.start();
        }
    }

    static class GreenhouseGo implements Runnable {
        private DelayQueue<DelayedGreenhouseTask> q;

        GreenhouseGo(DelayQueue<DelayedGreenhouseTask> q) {
            this.q = q;
        }

        public void run() {
            // System.out.println("GreenhouseGo DelayQueue: " + q);
            try {
                while (!Thread.interrupted()) {
                    q.take().run(); // Run task with the current thread
                }
            } catch (InterruptedException e) {
                // Acceptable way to exit
            }
            System.out.println("Finished GreenhouseGo");
        }
    }
}

public class GreenhouseScheduler {
    private static void repeat(GreenhouseController c, DelayedGreenhouseTask task, long interval, long duration) throws Exception {
        if (interval <= duration) {
            for (int i = 0; i < duration / interval; i++) {
                DelayedGreenhouseTask t = task.create(interval * (i + 1));
                c.tasks.put(t);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        GreenhouseController ghc = new GreenhouseController();
        repeat(ghc, ghc.new Bell(), 1000, 4000);
        repeat(ghc, ghc.new ThermostatNight(), 2000, 4000);
        repeat(ghc, ghc.new LightOn(), 200, 4000);
        repeat(ghc, ghc.new LightOff(), 400, 4000);
        repeat(ghc, ghc.new WaterOn(), 600, 4000);
        repeat(ghc, ghc.new WaterOff(), 800, 4000);
        repeat(ghc, ghc.new ThermostatDay(), 1400, 4000);
        repeat(ghc, ghc.new CollectData(), 500, 4000);
        ghc.tasks.put(ghc.new StopController(5000, exec));
        exec.execute(new GreenhouseController.GreenhouseGo(ghc.tasks));
    }
}
