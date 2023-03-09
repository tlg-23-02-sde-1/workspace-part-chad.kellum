package com.duckrace.app;

/*
 * Application "controller" Directs overall flow of the application, and coordinates all user promoting,
 * taking inputs and passing them into the system.
 *  */

import com.duckrace.Board;
import com.duckrace.Reward;
import static com.duckrace.Reward.*;

import java.util.Locale;
import java.util.Scanner;

public class DuckRaceApp {
    private Board board = Board.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private final int maxId = board.maxId();

    public void execute(){
        welcome();
        showBoard();
        int id = idPrompt();
        Reward reward = rewardPrompt();
        updateBoard(id, reward);
        showBoard();

    }

    private Reward rewardPrompt() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput){
            System.out.print("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")){    // no you can get your reward
                validInput = true;
                reward = ("D".equals(input)) ? DEBIT_CARD : PRIZES; // ternary

//                if ("D".equals(input)) {               // or use ternary operator here
//                    reward = Reward.DEBIT_CARD;
//                }
//                else {
//                    reward = Reward.PRIZES;
//                }
            }
        }

        return reward;

    }

    private int idPrompt() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.println();
            System.out.print("Please enter ID of the winner [1-" + maxId + "]: ");  //TODO, no hardcode 14, add method to Board, maxID
            String input = scanner.nextLine().trim();  //BLOCKS for input
            if (input.matches("\\d{1,2}")) {      // any digit, one or two times
                id = Integer.parseInt(input);          // now you can safely parseInt()
                if(1 <= id && id <= 14){
                    validInput = true;
                }
            }

        }

        return id;
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("W E L C O M E  T O  T H E  D U C K R A C E  A P P L I C A T I O N");
        System.out.println();
        System.out.println("******************************************************************");
        System.out.println();
    }


}