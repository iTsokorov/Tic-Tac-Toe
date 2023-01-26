package tsokorov;

import java.util.Scanner;

public class Main {

    private static final int PERSON = 1;
    private static final int COMPUTER = 0;
    static int[][] ticTacToeArray = {
            {-9, -9, -9},
            {-9, -9, -9},
            {-9, -9, -9}
    };

    public static void main(String[] args) {
        printTicTacToeCells(ticTacToeArray);
        while (true) {
            setCellPerson();
            if (checkWhoIsWinSimple(ticTacToeArray)){
                System.out.println("You win!");
                break;
            }
            setCellComputer();
            if (checkWhoIsWinSimple(ticTacToeArray)){
                System.out.println("Computer win!");
                break;
            }
        }
    }

    private static void setCellPerson() {
        System.out.println("Please enter digits from 1 to 9.");
        Scanner personInput = new Scanner(System.in);
        int cell;
        while (true) {
            if (personInput.hasNextInt()) {
                cell = personInput.nextInt();
                if (cell >= 1 && cell <= 9 && isEmptyCell(ticTacToeArray, cell)) {
                    fillCell(ticTacToeArray, PERSON, cell);
                    printTicTacToeCells(ticTacToeArray);
                    break;
                } else {
                    System.out.println("Wrong data! You are trying to put in filled cell!");
                }
            } else {
                System.out.println("Wrong data! Please try again. Please enter digits from 1 to 9.");
            }
            personInput.nextLine();
        }
    }

    private static boolean checkWhoIsWinSimple(int[][] array) {
        return (array[0][0] != -9 && array[0][1] == array[0][0] && array[0][2] == array[0][0]) ||
                (array[1][0] != -9 && array[1][1] == array[1][0] && array[1][2] == array[1][0]) ||
                (array[2][0] != -9 && array[2][1] == array[2][0] && array[2][2] == array[2][0]) ||
                (array[0][0] != -9 && array[1][0] == array[0][0] && array[2][0] == array[0][0]) ||
                (array[0][1] != -9 && array[1][1] == array[0][1] && array[2][1] == array[0][1]) ||
                (array[0][2] != -9 && array[1][2] == array[0][2] && array[2][2] == array[0][2]) ||
                (array[0][0] != -9 && array[1][1] == array[0][0] && array[2][2] == array[0][0]) ||
                (array[0][2] != -9 && array[1][1] == array[0][2] && array[2][0] == array[0][2]);
    }
    private static void setCellComputer() {
        while (true) {
            int cell = (int) (Math.random() * 9) + 1;
            if (isEmptyCell(ticTacToeArray, cell)) {
                fillCell(ticTacToeArray, COMPUTER, cell);
                printTicTacToeCells(ticTacToeArray);
                break;
            }
        }
    }

    private static boolean isEmptyCell(int[][] ticTacToeArray, int cell) {
        if (cell == 1 && ticTacToeArray[0][0] == -9) return true;
        else if (cell == 2 && ticTacToeArray[0][1] == -9) return true;
        else if (cell == 3 && ticTacToeArray[0][2] == -9) return true;
        else if (cell == 4 && ticTacToeArray[1][0] == -9) return true;
        else if (cell == 5 && ticTacToeArray[1][1] == -9) return true;
        else if (cell == 6 && ticTacToeArray[1][2] == -9) return true;
        else if (cell == 7 && ticTacToeArray[2][0] == -9) return true;
        else if (cell == 8 && ticTacToeArray[2][1] == -9) return true;
        else return (cell == 9 && ticTacToeArray[2][2] == -9);

    }


    private static void fillCell(int[][] ticTacToeArray, int type, int cell) {
        switch (cell) {
            case 1, 2, 3 -> ticTacToeArray[0][cell - 1] = type;
            case 4, 5, 6 -> ticTacToeArray[1][cell - 4] = type;
            case 7, 8, 9 -> ticTacToeArray[2][cell - 7] = type;
        }
    }

    private static void printTicTacToeCells(int[][] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                beautifulPrint(array, i, j);
            }
            System.out.println();
        }
    }

    private static void beautifulPrint(int[][] array, int i, int j) {
        if (array[i][j] == 1) {
            System.out.print("X" + "\t");
        } else if (array[i][j] == 0) {
            System.out.print("0" + "\t");
        } else {
            System.out.print("*" + "\t");
        }
    }
}