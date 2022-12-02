package ru.vsu.cs;

public class ArrestCell extends Cell {

    public ArrestCell() {

    }

    @Override
    public String getName() {
        return "Ячейка ареста";
    }

    @Override
    public void run(Player player) {
        System.out.println("[ARRESTCELL.RUN] Игрок " + player.getName() + " арестован!");
        player.setArrested(true);
        player.setArrestedNow(true);
    }
}
