package com.lypgod.test.tij4.practices.Ch19_EnumeratedTypes.Practice11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// Vending elements as classes implementing common interface:
interface VendingInput {
    String name();
}

class MonetaryUnit implements VendingInput {
    private String name;
    private int amount = 0;

    MonetaryUnit(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String name() {
        return name;
    }

    public int amount() {
        return amount;
    }
}

class VendedItem implements VendingInput {
    private String name;
    private int price = 0;

    VendedItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String name() {
        return name;
    }

    public int price() {
        return price;
    }
}

class VendingEvent implements VendingInput {
    private String name;

    VendingEvent(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}

class FileInputGenerator11 implements Generator<VendingInput> {
    private ArrayList<String> list;
    private List<VendingInput> vendList = new ArrayList<>();
    private Iterator<VendingInput> it;
    private Random rand = new Random();
    private Iterator<String> input = new TextFile("VendingMachineInput.txt", ";").iterator();

    // Construct List of VendingInput from appropriately formatted txt file:
    public FileInputGenerator11(String fileName) {
        list = new TextFile(fileName, ",|;|:");
        int m = list.indexOf("Money");
        int se = list.indexOf("Selection");
        int e = list.indexOf("VendingEvent");
        VendingInput vIn;
        for (String s : list) {
            int x = list.indexOf(s);
            if (m < x && x < se) {
                String[] sa = s.split("\\(|\\)");
                vIn = new MonetaryUnit(sa[0], Integer.parseInt(sa[1]));
                vendList.add(vIn);
            } else if (se < x && x < e) {
                String[] sa = s.split("\\(|\\)");
                vIn = new VendedItem(sa[0], Integer.parseInt(sa[1]));
                vendList.add(vIn);
            } else if (e < x) {
                vIn = new VendingEvent(s);
                vendList.add(vIn);
            }
        }
        it = vendList.iterator();
    }

    public VendingInput next() {
        if (list.isEmpty())
            return null;
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public VendingInput randomNext() {
        return vendList.get(rand.nextInt(vendList.size()));
    }

    public VendingInput textExampleNext(String fileName) {
        if (!input.hasNext())
            return null;
        String s = input.next().trim();
        String s1 = s.charAt(0) + s.substring(1).toLowerCase();
        for (VendingInput aVendList : this.vendList) {
            if (aVendList.name().equals(s1)) {
                return aVendList;
            }
        }
        return null;
    }
}

public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static VendedItem selection = null;

    static void run(Generator<VendingInput> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient)
                state.next();
            state.output();
        }
        state = State.RESTING;
        System.out.println();
    }

    static void runRandom(Generator<VendingInput> gen) {
        while (state != State.TERMINAL) {
            state.next(((FileInputGenerator11) gen).randomNext());
            while (state.isTransient)
                state.next();
            state.output();
        }
        state = State.RESTING;
        System.out.println();
    }

    static void runTextExample(Generator<VendingInput> gen) {
        while (state != State.TERMINAL) {
            // for(int i = 0; i < 16; i++) {
            state.next(((FileInputGenerator11) gen).textExampleNext("VendingMachineInput.txt"));
            while (state.isTransient)
                state.next();
            state.output();
        }
        state = State.RESTING;
        System.out.println();
    }

    public static void main(String[] args) {
        FileInputGenerator11 gen = new FileInputGenerator11("VendingMachine11Input.txt");
        runRandom(gen); // random vending inputs
        run(gen);
        runTextExample(gen); // inputs from VendingMachineInput.txt
    }

    enum StateDuration {TRANSIENT} // Tagging enum

    enum State {
        RESTING {
            void next(VendingInput in) {
                if (MonetaryUnit.class.isInstance(in)) {
                    amount += ((MonetaryUnit) in).amount();
                    state = ADDING_MONEY;
                }
                if (VendingEvent.class.isInstance(in)) {
                    if (in.name().equals("Stop"))
                        state = TERMINAL;
                }
            }
        }, ADDING_MONEY {
            void next(VendingInput in) {
                if (MonetaryUnit.class.isInstance(in)) {
                    amount += ((MonetaryUnit) in).amount();
                }
                if (VendedItem.class.isInstance(in)) {
                    selection = (VendedItem) in;
                    if (amount < selection.price())
                        System.out.println("Insufficient money for " + selection.name());
                    else
                        state = DISPENSING;
                }
                if (VendingEvent.class.isInstance(in)) {
                    if (in.name().equals("AbortTransaction"))
                        state = GIVING_CHANGE;
                    if (in.name().equals("Stop"))
                        state = TERMINAL;
                }
            }
        }, DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                System.out.println("here is your " + selection.name());
                amount -= selection.price();
                state = GIVING_CHANGE;
            }
        }, GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        }, TERMINAL {
            void output() {
                System.out.println("Halted");
            }
        };
        private boolean isTransient = false;

        State() {
        } // no-arg constructor

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(VendingInput in) {
            throw new RuntimeException("Only call " + "next(VendingInput in) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
        }

        void output() {
            System.out.println(amount);
        }
    }
}
