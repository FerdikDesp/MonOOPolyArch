package ru.vsu.cs;

public class LuxuryTaxCell extends Cell {

    public LuxuryTaxCell() {

    }

    @Override
    public String getName() {
        return "Ячейка Налог на роскошь";
    }

    @Override
    public void run(Player player) {
        System.out.println("[INCOMETAXCELL.RUN] Игрок " + player.getName() + " теряет 1000$!");
        player.setMoney(player.getMoney() - 1000);
    }

}
