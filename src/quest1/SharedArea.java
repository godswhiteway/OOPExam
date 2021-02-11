/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest1;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author akyol
 */
public class SharedArea {

    private final int[][] array;
    int row = 0;
    int col = 0;

    public SharedArea(int m, int p) {
        this.array = new int[m][p];

        for (int i = 0; i < m; i++) {
            

            for (int a = 0; a < p; a++) {
                array[i][a] = -1;
            }
        }
    }

    public synchronized void put(int value) {
        try {
            if (array[row][col] == -1) {
                array[row][col] = value;
                col++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            row++;
            col = 0;
            array[row][col] = value;
            col++;
        }
    }

    public synchronized String toString() {
        String returned = "";
        for(int t=0;t<array.length;t++){
            returned += Arrays.toString(array[t]) + "\n";
        }
    return returned;
    }
}
