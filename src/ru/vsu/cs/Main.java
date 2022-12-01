package ru.vsu.cs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        List<Cell> cells = new ArrayList<>();
        List<Player> players = new ArrayList<>();

        File cellsFile = new File("src/config/cells.ini");
        Scanner cellsScan = new Scanner(cellsFile);
        while (cellsScan.hasNextLine()) {
            List<String> cellProperties = Arrays.asList(cellsScan.nextLine().split(", "));
            switch (cellProperties.get(0)) {
                case "Start" -> cells.add(new StartCell());
                case "Random" -> cells.add(new RandomCell());
                case "IncomeTax" -> cells.add(new IncomeTaxCell());
                case "Jail" -> cells.add(new JailCell());
                case "Jackpot" -> cells.add(new JackpotCell());
                case "Arrest" -> cells.add(new ArrestCell());
                case "LuxuryTax" -> cells.add(new LuxuryTaxCell());
                default -> {
                    switch (cellProperties.get(2)) {
                        case "Cars" -> {
                            String name = cellProperties.get(0);
                            int cost = Integer.parseInt(cellProperties.get(1));
                            int rent = Integer.parseInt(cellProperties.get(3));
                            int rent1 = Integer.parseInt(cellProperties.get(4));
                            int rent2 = Integer.parseInt(cellProperties.get(5));
                            int rent3 = Integer.parseInt(cellProperties.get(6));
                            cells.add(new CarsCell(name, cost, rent, rent1, rent2, rent3));
                        }
                        case "Games" -> {
                            String name = cellProperties.get(0);
                            int cost = Integer.parseInt(cellProperties.get(1));
                            int rent = Integer.parseInt(cellProperties.get(3));
                            int rent1 = Integer.parseInt(cellProperties.get(4));
                            cells.add(new GamesCell(name, cost, rent, rent1));
                        }
                        default -> {
                            String name = cellProperties.get(0);
                            int cost = Integer.parseInt(cellProperties.get(1));
                            String type = cellProperties.get(2);
                            int rent = Integer.parseInt(cellProperties.get(3));
                            int rent1 = Integer.parseInt(cellProperties.get(4));
                            int rent2 = Integer.parseInt(cellProperties.get(5));
                            int rent3 = Integer.parseInt(cellProperties.get(6));
                            int rent4 = Integer.parseInt(cellProperties.get(7));
                            int rent5 = Integer.parseInt(cellProperties.get(8));
                            cells.add(new Business(name, cost, type, rent, rent1, rent2, rent3, rent4, rent5));
                        }
                    }
                }
            }
        }

        File playersFile = new File("src/config/players.ini");
        Scanner playersScan = new Scanner(playersFile);
        while (playersScan.hasNextLine()) {
            List<String> playersProperties = Arrays.asList(playersScan.nextLine().split(", "));
            players.add(new Player(playersProperties.get(0), Integer.parseInt(playersProperties.get(1))));
        }

        Game game = new Game();

        game.initialize(cells, players);

        int actualPlayer = 0;

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("======ИГРОКИ======");
            for (Player player: players) {
                System.out.println(player.getName() + " MONEY: " + player.getMoney());
            }
            System.out.println("==================");
            System.out.println("Ходит игрок " + players.get(actualPlayer).getName() + "!\n1. Бросить кубики");
            if (scan.nextInt() == 1) {
                Random rand = new Random();
                int num1 = rand.nextInt(6)+1;
                int num2 = rand.nextInt(6)+1;
                System.out.print("Выпали числа " + num1 + " и " + num2 + "!");
                if (num1 == num2) {
                    System.out.println(" Выпал дубль, а значит ход повторится!");
                } else {
                    System.out.println();
                }
                game.movePlayer(players.get(actualPlayer), num1+num2);
                game.runCell(players.get(actualPlayer));
                if (num1 == num2) {
                    actualPlayer--;
                }
            }
            actualPlayer++;
            if (actualPlayer == players.size()) {
                actualPlayer = 0;
            }
        }

    }
}
