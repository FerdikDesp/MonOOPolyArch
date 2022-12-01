package ru.vsu.cs;

import java.util.ArrayList;
import java.util.List;

public class GamesCell extends Cell {

    private String name;
    private int cost;
    private Player owner;
    private int branchCount;
    private List<Integer> branchCost = new ArrayList<>();

    public GamesCell(String name, int cost, int rent, int rent1) {
        this.name = name;
        this.cost = cost;
        this.owner = null;
        this.branchCount = 0;
        branchCost.add(rent);
        branchCost.add(rent1);
    }

    @Override
    public String getName() {
        return name;
    }
}
