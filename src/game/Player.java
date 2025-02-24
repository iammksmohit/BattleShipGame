package game;

import java.util.*;

public class Player {
    private final String name;
    private final List<Ship> ships;
    private final Set<Cordinates> shotsFired;

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
        this.shotsFired = new HashSet<>();
    }

    public void addPlayerShip(Ship ship) {
        ships.add(ship);
    }

    public boolean isShipsEmpty() {
        return ships.isEmpty();
    }

    public boolean attackWithTargetOnOpponent(Cordinates target, Player opponent) {
        if (shotsFired.contains(target)) {
            System.out.println("Player " + name + " already fired at (" + target.getX() + ", " + target.getY() + ")");
            return false;
        }
        shotsFired.add(target);

        Iterator<Ship> opponentShipsItr = opponent.ships.iterator();
        while (opponentShipsItr.hasNext()) {
            Ship ship = opponentShipsItr.next();
            if (ship.getAllPositions().remove(target)) {
                System.out.println("Player " + name + " hit a ship!");
                if (ship.getAllPositions().isEmpty()) {
                    System.out.println("Player " + opponent.getName() + "'s ship is destroyed!");
                    opponentShipsItr.remove();
                }
                return true;
            }
        }

        System.out.println("Player " + name + " missed.");
        return false;
    }

    public String getName() {
        return name;
    }

    public Set<Cordinates> getShotsFired() {
        return shotsFired;
    }
}
