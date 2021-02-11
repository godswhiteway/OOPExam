/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest1;

/**
 *
 * @author akyol
 */
public class MultiplyWorker extends Thread {

    private final SharedArea a;
    private int[] row;
    private int[][] matrix;

    public MultiplyWorker(String name, SharedArea buffer, int[] row, int[][] matrix) {
        super(name);
        this.a = buffer;
        this.row = row;
        this.matrix = matrix;
    }

    public void run() {
        int sum = 0;
        int ct = 0;
        for (int d = 0; d < matrix[0].length; d++) {
            for (int y = 0; y < matrix.length; y++) {
                try {    
                    sum += row[y] * matrix[y][ct];
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            ct++;
            a.put(sum);
            sum = 0;
        }
            ct = 0;
    }
}
