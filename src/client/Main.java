package client;

import game.Cordinates;
import game.GameBoard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Battle Field...");
        GameBoard gameBoard = new GameBoard();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Field Size: ");
        int sizeOfField = scanner.nextInt();
        gameBoard.initGame(sizeOfField);

        System.out.println("Enter Player A (x,y) Coordinates: ");
        Cordinates playerACordinates = new Cordinates(scanner.nextInt(), scanner.nextInt());

        System.out.println("Enter Player B (x,y) Coordinates: ");
        Cordinates playerBCordinates = new Cordinates(scanner.nextInt(), scanner.nextInt());

        System.out.println("Enter the Ship Size for Both Players: ");
        int sizeOfShip = scanner.nextInt();
        gameBoard.addShips("SH", sizeOfShip, playerACordinates, playerBCordinates);

        gameBoard.viewBattleField();
        gameBoard.startGame();
    }
}