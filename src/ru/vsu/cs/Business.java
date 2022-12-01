package ru.vsu.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Business extends Cell {
    private String name;
    private int cost;
    private String type;
    private Player owner;
    private int branchCount;
    private List<Integer> branchCost = new ArrayList<>();

    public Business(String name, int cost, String type, int rent, int rent1, int rent2, int rent3, int rent4, int rent5) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.owner = null;
        this.branchCount = 0;
        branchCost.add(rent);
        branchCost.add(rent1);
        branchCost.add(rent2);
        branchCost.add(rent3);
        branchCost.add(rent4);
        branchCost.add(rent5);
    }

    public int getBranchCount() {
        return branchCount;
    }

    public List<Integer> getBranchCost() {
        return branchCost;
    }

    public String getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public void run(Player player) {
        if (this.owner == null) {
            System.out.println("Бизнес никем не занят! Купить бизнес? Цена: " + this.getCost() + "\n1. Да\t2. Нет");
            Scanner scan = new Scanner(System.in);
            int action = scan.nextInt();
            switch (action) {
                case 1 -> {
                    player.setMoney(player.getMoney() - this.getCost());
                    this.setOwner(player);
                }
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
