package game;

public class BattleField {
    private final Integer size;
    private final char[][] field;

    public BattleField(Integer size) {
        this.size = size;
        this.field = new char[size][size];
        for (char[] row : field) {
            java.util.Arrays.fill(row, '.');
        }
    }

    public void placeShip(Ship ship, char identifier) {
        for (Cordinates pos : ship.getAllPositions()) {
            if (pos.getX() < size && pos.getY() < size) {
                field[pos.getX()][pos.getY()] = identifier;
            }
        }
    }

    public void displayBattleShip() {
        for (char[] row : field) {
            System.out.println(new String(row));
        }
    }
}
