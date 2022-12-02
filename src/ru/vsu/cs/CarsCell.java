package ru.vsu.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarsCell extends Cell {

    private String name;
    private int cost;
    private Player owner;
    private int branchCount;
    private List<Integer> branchCost = new ArrayList<>();

    public CarsCell(String name, int cost, int rent, int rent1, int rent2, int rent3) {
        this.name = name;
        this.cost = cost;
        this.owner = null;
        this.branchCount = 0;
        branchCost.add(rent);
        branchCost.add(rent1);
        branchCost.add(rent2);
        branchCost.add(rent3);
    }

    public int getCost() {
        return cost;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run(Player player) {
        if (this.owner == null) {
            System.out.println("Бизнес никем не занят! Купить бизнес? Цена: " + this.getCost() + "\n1. Да\t2. Нет");
            Scanner scan = new Scanner(System.in);
            int action = scan.nextInt();
            if (action == 1) {
                player.setMoney(player.getMoney() - this.getCost());
                this.setOwner(player);
            }
        } else if (this.owner == player) {
            System.out.println("Игрок " + player.getName() + " попал на собственный бизнес! Пропуск хода.");
        } else {
            System.out.println("Игрок " + player.getName() + " попал на бизнес игрока " + this.owner.getName() + " и обязан заплатить аренду " + this.branchCost.get(this.branchCount));
            player.setMoney(player.getMoney() - this.branchCost.get(this.branchCount));
            this.owner.setMoney(this.owner.getMoney() + this.branchCost.get(this.branchCount));
        }
    }

}
