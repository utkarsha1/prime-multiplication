package com.utkarsha.fc.util;

/**
 * Created by utkarsha on 6/25/16.
 */
public class FormattedArrayPrinter {

    public void printFormattedArray(int[][] array) {
        for(int[] row : array) {
            printRow(row);
        }
    }

    private void printRow(int[] row) {
        for (int rowElement : row) {
            if(rowElement == 0) {
                System.out.printf("%6s\t", "");
            } else {
                System.out.printf("|%6d\t", rowElement);
            }
        }
        System.out.println("|");
    }
}
