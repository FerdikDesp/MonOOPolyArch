package ru.vsu.cs;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Player> playerList = new ArrayList<>();

    public Cell() {

    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayer(Player player) {
        playerList.add(player);
        player.setCurrentCell(this);
    }

    public void removePlayer(Player player) {
        playerList.remove(player);
        player.setCurrentCell(null);
    }

    public String getName() {
        return null;
    }

    public void run(Player player) {

    }
}
