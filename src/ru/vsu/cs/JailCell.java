package ru.vsu.cs;

import java.util.Random;
import java.util.Scanner;

public class JailCell extends Cell {

    public JailCell() {

    }

    @Override
    public String getName() {
        return "Отдел полиции";
    }

    @Override
    public void run(Player player) {
        if (player.isArrested()) {
            System.out.println("[JAILCELL.RUN] Игрок " + player.getName() + " арестован!\n1. Заплатить 500$\n2. Попробовать кинуть дубль");
            Scanner scan = new Scanner(System.in);
            int action = scan.nextInt();
            switch (action) {
                case 1: {
                    System.out.println("[JAILCELL.RUN] Игрок " + player.getName() + " заплатил 500$ и вышел из тюрьмы!");
                    player.setMoney(player.getMoney() - 500);
                    player.setArrested(false);
                    break;
                }
                case 2: {
                    System.out.println("[JAILCELL.RUN] Игрок " + player.getName() + " кидает дубль...");
                    Random rand = new Random();
                    int num1 = rand.nextInt(6)+1;
                    int num2 = rand.nextInt(6)+1;
                    if (num1 == num2) {
                        System.out.println("[JAILCELL.RUN] Игрок " + player.getName() + " выбил дубль!");
                        player.setWinTryUnArrest(num1+num2);
                        player.setLostTriesUnArrest(0);
                    } else {
                        System.out.print("[JAILCELL.RUN] Игрок " + player.getName() + " не выбил дубль!");
                        player.setLostTriesUnArrest(player.getLostTriesUnArrest() + 1);
                        System.out.println(" Количество неуд. попыток: " + player.getLostTriesUnArrest());
                    }
                    break;
                }
            }
        } else {
            System.out.println("[JAILCELL.RUN] Игрок " + player.getName() + " посетил полицейский участок с экскурсией.");
        }
    }
}
