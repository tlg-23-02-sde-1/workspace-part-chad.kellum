package com.duckrace;

import static com.duckrace.Reward.*;

class BoardTest {

    public static void main(String[] args) {
        Board board = new Board();
//        board.dumpStudentIdMap();
        System.out.println();

        board.update(2, PRIZES);
        board.update(3, DEBIT_CARD);
        board.update(7, PRIZES);
        board.update(12, DEBIT_CARD);
        board.update(12, PRIZES);

        board.show();

    }

}