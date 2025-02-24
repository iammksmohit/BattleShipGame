package game;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final String name;
    private final Integer size;
    private final List<Cordinates> allPositions = new ArrayList<>();

    public Ship(String name, Integer size, Cordinates cordinates, int boardSize) {
        this.name = name;
        this.size = size;
        fillAllCordinates(size, cordinates, boardSize);
    }

    private void fillAllCordinates(Integer size, Cordinates cordinates, int boardSize) {
        int centerX = cordinates.getX();
        int centerY = cordinates.getY();

        // Calculate top-left corner ensuring it stays within bounds
        int startX = Math.max(0, centerX - size / 2);
        int startY = Math.max(0, centerY - size / 2);

        // Ensure ship doesn't go out of board size
        int maxX = Math.min(startX + size, boardSize);
        int maxY = Math.min(startY + size, boardSize);

        // Store all occupied coordinates
        for (int x = startX; x < maxX; x++) {
            for (int y = startY; y < maxY; y++) {
                allPositions.add(new Cordinates(x, y));
            }
        }

    }

    public List<Cordinates> getAllPositions() {
        return allPositions;
    }
}
