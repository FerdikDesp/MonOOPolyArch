package ru.vsu.cs;

import java.util.Random;

public class RandomCell extends Cell {

    public RandomCell(){

    }

    @Override
    public String getName() {
        return "Ячейка Шанс";
    }

    @Override
    public void run(Player player) {
        /*
        1. ПОТЕРЯ ХОДА
        2. +750 (ВОЗВРАТ НАЛОГА)
        3. +1500 (ЛОТЕРЕЯ)
        4. -1000 (КАЗИНО)
        5. -250 (РАСПРОДАЖА)
        6. +500 (ДЕНЬ РОЖДЕНИЯ)
        7. ТЕЛЕПОРТАЦИЯ (СДВИГ ОТ 10 ДО 20 ЯЧЕЕК)
        8. +1500 (ВТОРОЕ МЕСТО В КОНКУРСЕ КРАСОТЫ)
        9. АРЕСТ
         */

        Random random = new Random();

        int randNumber = random.nextInt(9) + 1;

        switch (randNumber) {
            case 1: System.out.println("[RANDOMCELL.RUN] Игрок " + player.getName() + " теряет ход!");  break;
            case 2: {
                System.out.println("[RANDOMCELL.RUN] Игрок " + player.getName() + " получает 750$!");
                player.setMoney(player.getMoney() + 750);
                break;
            }
            case 3: {
                System.out.println("[RANDOMCELL.RUN] Игрок " + player.getName() + " получает 1500$ за выигрыш в лотерее!");
                player.setMoney(player.getMoney() + 1500);
                break;
            }
            case 4: {
                System.out.println("[RANDOMCELL.RUN] Игрок " + player.getName() + " теряет 1000$!");
                player.setMoney(player.getMoney() - 1000);
                break;
            }
            case 5: {
                System.out.println("[RANDOMCELL.RUN] Игрок " + player.getName() + " теряет 250$!");
                player.setMoney(player.getMoney() - 250);
                break;
            }
            case 6: {
                System.out.println("[RANDOMCELL.RUN] Игрок " + player.getName() + " получает 500$!");
                player.setMoney(player.getMoney() + 500);
                break;
            }
            case 7: {
                System.out.println("[RANDOMCELL.RUN] Игрок " + player.getName() + " перемещается!");
                break;
            }
            case 8: {
                System.out.println("[RANDOMCELL.RUN] Игрок " + player.getName() + " получает 1500$ за второе место в конкурсе красоты!");
                player.setMoney(player.getMoney() + 1500);
                break;
            }
            case 9: {
                System.out.println("[RANDOMCELL.RUN] Игрок " + player.getName() + " арестован!");
                player.setArrested(true);
                player.setArrestedNow(true);
                break;
            }
        }

    }

}
