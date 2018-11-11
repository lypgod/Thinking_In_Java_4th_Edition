package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice17;

import java.util.Random;

interface Game { void toss(int times); }

public class TossGameTest {
    private static Game getCoinGame() {
      return new Game() {
          @Override
          public void toss(int times) {
              for (int i = 0; i < times; i++) {
                  if (new Random().nextInt(2) == 0) {
                      System.out.println("Coin Head.");
                  } else {
                      System.out.println("Coin Tail.");
                  }
              }
          }
      };
    }
    private static Game getDiceGame() {
        return new Game() {
            @Override
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
        };
    }

    private static void play(Game game, int times) {
        game.toss(times);
    }
    public static void main(String[] args) {
        play(getCoinGame(), 5);
        play(getDiceGame(), 10);
    }
}
