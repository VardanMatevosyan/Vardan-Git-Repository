package ru.matevosyan.model;

import java.util.concurrent.locks.ReentrantLock;

/**
 * GameBoard class which is represent board for bomberman game.
 * @author Matevosyan Vardan
 * @version 1.0
 * created on 24.11.2017
 */

public class GameBoard {

//    public CellOfGameBoard getCurrentCellOfGameBoard() {
//        return new CellOfGameBoard( random.nextInt(boardSize),  random.nextInt(boardSize), Directions.NONE);
//    }

//    private CellOfGameBoard currentCellOfGameBoard;
//    private CellOfGameBoard cellOfStartPosition;

//    private Random random = new Random();


    private final ReentrantLock[][] gameBoard;
    private final int boardSize;

    /**
     * Constructor.
     * @param boardSize board size.
     */
    public GameBoard(final int boardSize) {
        this.gameBoard = new ReentrantLock[boardSize][boardSize];
        this.boardSize = boardSize;
        this.initBorderGame();
//        currentCellOfGameBoard = new CellOfGameBoard( random.nextInt(boardSize),  random.nextInt(boardSize), Directions.NONE);
    }

    /**
     * initialize game board.
     */
    private void initBorderGame() {
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard.length; j++) {
                this.gameBoard[i][j] = new ReentrantLock();
            }
        }
    }

    /**
     * Get board size.
     * @return board size.
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * get game board.
     * @return board.
     */
    public ReentrantLock[][] getGameBoard() {
        return gameBoard;
    }


//    public CellOfGameBoard getCellOfStartPosition() {
//        return cellOfStartPosition;
//    }

//    public Bomberman getBomberman() {
//        return bomberman;
////    }

//    private void startBombermanPosition() {
//        this.gameBoard[starCellX][startCellY] = this.bomberman;
//        this.gameBoard[starCellX][startCellY].lock();
//    }

}
