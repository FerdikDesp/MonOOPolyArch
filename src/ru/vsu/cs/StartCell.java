package ru.vsu.cs;

public class StartCell extends Cell {

    public StartCell() {

    }

    @Override
    public String getName() {
        return "Стартовая ячейка";
    }

    @Override
    public void run(Player player) {
        System.out.println("[STARTCELL.RUN] Игрок " + player.getName() + " оказался на стартовой ячейке и получает 1000$");
        player.setMoney(player.getMoney() + 1000);
    }

}
