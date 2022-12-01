package ru.vsu.cs;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Cell> cells;
    private List<Player> players;
    private int actualPlayer;

    public Game() {
        this.cells = new ArrayList<>();
        this.players = new ArrayList<>();
        this.actualPlayer = 0;
    }

    public void initialize(List<Cell> cells, List<Player> players) {
        this.cells = cells;
        this.players = players;
        //РАЗМЕЩЕНИЕ ИГРОКОВ НА СТАРТОВОЙ ЯЧЕЙКЕ
        for (Player player: players) {
            //cells.get(0).getPlayerList().add(player);
            cells.get(0).setPlayer(player);
        }
        actualPlayer = 0;
    }

    public void movePlayer(Player player, int shift) {
        System.out.print("[MOVEPLAYER] Игрок " + player.getName() + " находится в " + player.getCurrentCell().getName() + ", номер ячейки " + cells.indexOf(player.getCurrentCell()) + ". ");
        //НАЧАЛО ПЕРЕНОСА ИГРОКА НА ДРУГУЮ ЯЧЕЙКУ
        int newCellNumber = cells.indexOf(player.getCurrentCell()) + shift;
        cells.get(cells.indexOf(player.getCurrentCell())).removePlayer(player);
        if (newCellNumber >= cells.size()) {
            cells.get(newCellNumber - cells.size()).setPlayer(player);
        } else {
            cells.get(newCellNumber).setPlayer(player);
        }
        //КОНЕЦ ПЕРЕНОСА ИГРОКА НА ДРУГУЮ ЯЧЕЙКУ
        System.out.println("Перемещён в " + player.getCurrentCell().getName() + ", номер ячейки " + cells.indexOf(player.getCurrentCell()));
    }

    public void runCell(Player player) {
        Cell cell = cells.get(cells.indexOf(player.getCurrentCell()));
        cell.run(player);
    }
}
