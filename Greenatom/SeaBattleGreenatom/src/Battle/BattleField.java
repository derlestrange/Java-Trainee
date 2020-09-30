package Battle;

import com.sun.istack.internal.NotNull;

import java.util.Scanner;

public class BattleField {

    public static Scanner reader = new Scanner(System.in);

    public BattleField() {
        Player player = new Player();
        initializationField(player);

        Player computer = new Player();
        initializationAiField(computer);
        computer.playerGrid.printShips();

        String result = "";
        while (true) {
            System.out.println(result);
            result = playerTurn(player, computer);
            if (player.playerGrid.hasLost()) {
                System.out.println("Ты проиграл!!!");
                break;
            } else if (computer.playerGrid.hasLost()) {
                System.out.println("Ты победил!!!");
                break;
            }
            computerTurn(computer, player);
        }
    }

    private static void computerTurn(Player comp, Player user) {
        int rows = 0;
        int columns = 0;

        while (comp.oppGrid.alreadyGuessed(rows, columns)) {
            rows = Randomizer.nextInt(0, 9);
            columns = Randomizer.nextInt(0, 9);
        }

        if (user.playerGrid.hasShip(rows, columns)) {
            comp.oppGrid.markHit(rows, columns);
            user.playerGrid.markHit(rows, columns);
            System.out.println("ИИ попал: " + convertIntToLetter(rows) + convertCompColToRegular(columns));

        } else {
            comp.oppGrid.markMiss(rows, columns);
            user.playerGrid.markMiss(rows, columns);
            System.out.println("ИИ промахнулся: " + convertIntToLetter(rows) + convertCompColToRegular(columns));
        }

        System.out.println("\nТвоя доска:");
        user.playerGrid.printCombined();
        System.out.println("\n");
    }

    private static String playerTurn(Player p, Player opp) {
        p.oppGrid.printStatus();

        int rows = -1;
        int columns = -1;

        String oldRows = "Z";
        int oldColumns = -1;

        while (true) {
            System.out.print("Выбери строку от A до J: ");
            String userInputRow = reader.next();
            userInputRow = userInputRow.toUpperCase();
            oldRows = userInputRow;
            rows = convertLetterToInt(userInputRow);

            System.out.print("Выбери колонку от 1 до 10: ");
            columns = reader.nextInt();
            oldColumns = columns;
            columns = convertUserColToProCol(columns);
            System.out.println("\n");

            if (columns >= 0 && columns <= 9 && rows != -1)
                break;

            System.out.println("Попробуй еще раз!");
        }

        if (opp.playerGrid.hasShip(rows, columns)) {
            p.oppGrid.markHit(rows, columns);
            opp.playerGrid.markHit(rows, columns);
            return "Ты попал! " + oldRows + oldColumns;
        } else {
            p.oppGrid.markMiss(rows, columns);
            opp.playerGrid.markMiss(rows, columns);
            return "Ты не попал! " + oldRows + oldColumns;
        }
    }

    private static void initializationField(Player player) {
        System.out.println();
        int counter = 0;

        while (player.numOfShipsLeft() > 0) {
            for (Ship ship : player.ships) {
                int rows = Randomizer.nextInt(0, 9);
                int columns = Randomizer.nextInt(0, 9);
                int directions = Randomizer.nextInt(0, 1);


                while (initializationError(rows, columns, directions, player, counter)) {
                    rows = Randomizer.nextInt(0, 9);
                    columns = Randomizer.nextInt(0, 9);
                    directions = Randomizer.nextInt(0, 1);
                }

                player.ships[counter].setLocation(rows, columns);
                player.ships[counter].setDirection(directions);
                player.playerGrid.addShip(player.ships[counter]);

                counter++;
            }
        }
    }

    private static void initializationAiField(Player player) {
        System.out.println();
        int counter = 0;

        while (player.numOfShipsLeft() > 0) {
            for (Ship ship : player.ships) {
                int rows = Randomizer.nextInt(0, 9);
                int columns = Randomizer.nextInt(0, 9);
                int directions = Randomizer.nextInt(0, 1);


                while (initializationError(rows, columns, directions, player, counter)) {
                    rows = Randomizer.nextInt(0, 9);
                    columns = Randomizer.nextInt(0, 9);
                    directions = Randomizer.nextInt(0, 1);
                }

                player.ships[counter].setLocation(rows, columns);
                player.ships[counter].setDirection(directions);
                player.playerGrid.addShip(player.ships[counter]);

                counter++;
            }
        }
    }

    @NotNull
    private static boolean initializationError(int rows, int columns, int direction, Player player, int count) {
        int length = player.ships[count].getLength();

        if (direction == 0) {
            int checker = length + columns;
            if (checker > 10) {
                return true;
            }
        }
        if (direction == 1) {
            int checker = length + rows;
            if (checker > 10) {
                return true;
            }
        }

        if (direction == 0) {
            for (int i = columns; i < columns + length; i++) {
                if (player.playerGrid.hasShip(rows, i)) {
                    return true;
                }
            }
        } else if (direction == 1) {
            for (int i = rows; i < rows + length; i++) {
                if (player.playerGrid.hasShip(i, columns)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int convertLetterToInt(String value) {
        int toReturn;
        switch (value) {
            case "A":
                toReturn = 0;
                break;
            case "B":
                toReturn = 1;
                break;
            case "C":
                toReturn = 2;
                break;
            case "D":
                toReturn = 3;
                break;
            case "E":
                toReturn = 4;
                break;
            case "F":
                toReturn = 5;
                break;
            case "G":
                toReturn = 6;
                break;
            case "H":
                toReturn = 7;
                break;
            case "I":
                toReturn = 8;
                break;
            case "J":
                toReturn = 9;
                break;
            default:
                toReturn = -1;
                break;
        }

        return toReturn;
    }

    private static String convertIntToLetter(int value) {
        String toReturn;
        switch (value) {
            case 0:
                toReturn = "A";
                break;
            case 1:
                toReturn = "B";
                break;
            case 2:
                toReturn = "C";
                break;
            case 3:
                toReturn = "D";
                break;
            case 4:
                toReturn = "E";
                break;
            case 5:
                toReturn = "F";
                break;
            case 6:
                toReturn = "G";
                break;
            case 7:
                toReturn = "H";
                break;
            case 8:
                toReturn = "I";
                break;
            case 9:
                toReturn = "J";
                break;
            default:
                toReturn = "Z";
                break;
        }
        return toReturn;
    }

    private static int convertUserColToProCol(int value) {
        int toReturn;
        switch (value) {
            case 1:
                toReturn = 0;
                break;
            case 2:
                toReturn = 1;
                break;
            case 3:
                toReturn = 2;
                break;
            case 4:
                toReturn = 3;
                break;
            case 5:
                toReturn = 4;
                break;
            case 6:
                toReturn = 5;
                break;
            case 7:
                toReturn = 6;
                break;
            case 8:
                toReturn = 7;
                break;
            case 9:
                toReturn = 8;
                break;
            case 10:
                toReturn = 9;
                break;
            default:
                toReturn = -1;
                break;
        }
        return toReturn;
    }

    private static int convertCompColToRegular(int value) {
        int toReturn;
        switch (value) {
            case 0:
                toReturn = 1;
                break;
            case 1:
                toReturn = 2;
                break;
            case 2:
                toReturn = 3;
                break;
            case 3:
                toReturn = 4;
                break;
            case 4:
                toReturn = 5;
                break;
            case 5:
                toReturn = 6;
                break;
            case 6:
                toReturn = 7;
                break;
            case 7:
                toReturn = 8;
                break;
            case 8:
                toReturn = 9;
                break;
            case 9:
                toReturn = 10;
                break;
            default:
                toReturn = -1;
                break;
        }

        return toReturn;
    }
}