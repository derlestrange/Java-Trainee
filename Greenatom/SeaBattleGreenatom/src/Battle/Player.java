package Battle;

public class Player {
    private static final int[] SHIP_LENGTHS = {2, 2, 3, 3, 4};
    private static final int NUM_OF_SHIPS = 5;

    public Ship[] ships;
    public Field playerGrid;
    public Field oppGrid;

    public Player() {
        if (NUM_OF_SHIPS != 5) {
            throw new IllegalArgumentException("Кораблей должно быть 5");
        }

        ships = new Ship[NUM_OF_SHIPS];
        for (int i = 0; i < NUM_OF_SHIPS; i++) {
            Ship tempShip = new Ship(SHIP_LENGTHS[i]);
            ships[i] = tempShip;
        }

        playerGrid = new Field();
        oppGrid = new Field();
    }

//    public void addShips() {
//        for (Ship s : ships) {
//            playerGrid.addShip(s);
//        }
//    }

    public int numOfShipsLeft() {
        int counter = 5;
        for (Ship s : ships) {
            if (s.isLocationSet() && s.isDirectionSet())
                counter--;
        }

        return counter;

    }

//    public void chooseShipLocation(Ship s, int row, int col, int direction) {
//        s.setLocation(row, col);
//        s.setDirection(direction);
//        playerGrid.addShip(s);
//    }
}