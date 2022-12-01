package ru.vsu.cs;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String getName() {
        return name;
    }

}
