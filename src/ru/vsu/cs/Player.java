package ru.vsu.cs;

public class Player {

    private String name;
    private int money;
    private Cell currentCell;
    private boolean isArrested;
    private boolean isArrestedNow;
    private int lostTriesUnArrest;
    private int winTryUnArrest;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.currentCell = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public boolean isArrested() {
        return isArrested;
    }

    public void setArrested(boolean arrested) {
        isArrested = arrested;
    }

    public boolean isArrestedNow() {
        return isArrestedNow;
    }

    public void setArrestedNow(boolean arrestedNow) {
        isArrestedNow = arrestedNow;
    }

    public int getLostTriesUnArrest() {
        return lostTriesUnArrest;
    }

    public void setLostTriesUnArrest(int lostTriesUnArrest) {
        this.lostTriesUnArrest = lostTriesUnArrest;
    }

    public int getWinTryUnArrest() {
        return winTryUnArrest;
    }

    public void setWinTryUnArrest(int winTryUnArrest) {
        this.winTryUnArrest = winTryUnArrest;
    }
}