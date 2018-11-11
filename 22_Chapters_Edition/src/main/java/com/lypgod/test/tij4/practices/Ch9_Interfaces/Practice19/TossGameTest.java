package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice19;

import java.util.Random;

interface Game { void toss(int times); }
interface GameFactory { Game getGame(); }

class CoinGame implements Game {
    public void toss(int times) {
        for (int i = 0; i < times; i++) {
            if (new Random().nextInt(2) == 0) {
                System.out.println("Coin Head.");
            } else {

                System.out.println("Coin Tail.");
            }
        }
    }
}
class CoinGameFactory implements GameFactory {
    public Game getGame() {
        return new CoinGame();
    }
}
class DiceGame implements Game {
    public void toss(int times) {
        for (int i = 0; i < times; i++) {
            switch (new Random().nextInt(6)) {
                case 0:
                    System.out.println("Dice Face 1.");
                    break;
                case 1:
                    System.out.println("Dice Face 2.");
                    break;
                case 2:
                    System.out.println("Dice Face 3.");
                    break;
                case 3:
                    System.out.println("Dice Face 4.");
                    break;
                case 4:
                    System.out.println("Dice Face 5.");
                    break;
                case 5:
                    System.out.println("Dice Face 6.");
                    break;
            }
        }
    }
}
class DiceGameFactory implements GameFactory {
    public Game getGame() {
        return new DiceGame();
    }
}

public class TossGameTest {
    private static void play(GameFactory gameFactory, int times) {
        gameFactory.getGame().toss(times);
    }
    public static void main(String[] args) {
        play(new CoinGameFactory(), 5);
        play(new DiceGameFactory(), 10);
    }
}
