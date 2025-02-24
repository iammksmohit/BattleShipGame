package game;

import java.util.Random;

public class GameBoard {
    private Integer size;
    private Player playerA;
    private Player playerB;
    private BattleField battleField;
    private final Random randomNumGenerator = new Random();

    public void initGame(Integer size) {
        this.size = size;
        this.playerA = new Player("A");
        this.playerB = new Player("B");
        this.battleField = new BattleField(size);
    }

    public void addShips(String id, Integer size, Cordinates posA, Cordinates posB) {
        if (!isValidPlacement(posA, 'A') || !isValidPlacement(posB, 'B')) {
            System.out.println("Invalid ship placement! Must stay within assigned zones.");
            return;
        }
        Ship ship1 = new Ship("A-" + id, size, posA, this.size);
        Ship ship2 = new Ship("B-" + id, size, posB, this.size);
        playerA.addPlayerShip(ship1);
        playerB.addPlayerShip(ship2);
        battleField.placeShip(ship1, 'A');
        battleField.placeShip(ship2, 'B');
    }

    private boolean isValidPlacement(Cordinates start, char player) {
        return (player == 'A' && start.getX() < size / 2) || (player == 'B' && start.getX() >= size / 2);
    }

    public void viewBattleField() {
        battleField.displayBattleShip();
    }

    public void startGame() {
        System.out.println("Starting Game...");
        while (true) {
            if (attack(playerA, playerB) || attack(playerB, playerA)) break;
        }
        System.out.println(playerA.isShipsEmpty() ? "Game Over. Player B wins!" : "Game Over. Player A wins!");
    }

    private boolean attack(Player attacker, Player opponent) {
        Cordinates target;
        int startX = attacker.getName().equals("A") ? size / 2 : 0;
        int endX = attacker.getName().equals("A") ? size : size / 2;
        
        do {
            target = new Cordinates(randomNumGenerator.nextInt(endX - startX) + startX, randomNumGenerator.nextInt(size));
        } while (attacker.getShotsFired().contains(target));

        return attacker.attackWithTargetOnOpponent(target, opponent) && opponent.isShipsEmpty();
    }
}
