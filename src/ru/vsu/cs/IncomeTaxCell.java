package ru.vsu.cs;

public class IncomeTaxCell extends Cell {

    public IncomeTaxCell(){

    }

    @Override
    public String getName() {
        return "Ячейка Подоходный налог";
    }

    @Override
    public void run(Player player) {
        System.out.println("[INCOMETAXCELL.RUN] Игрок " + player.getName() + " теряет 2000$!");
        player.setMoney(player.getMoney() - 2000);
    }

}
