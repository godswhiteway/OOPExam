/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author akyol
 */
public class Main {

    public static void main(String[] arg) throws InterruptedException {
        int[][] matrix1 = matrixGetter("Matris1.txt");
        int[][] matrix2 = matrixGetter("Matris2.txt");
        SharedArea buffer = new SharedArea(matrix1.length,matrix2[0].length);
        MultiplyWorker test = new MultiplyWorker("a",buffer,matrix1[0],matrix2);
        MultiplyWorker test2 = new MultiplyWorker("b",buffer,matrix1[1],matrix2);
        //MultiplyWorker test3 = new MultiplyWorker("ba",buffer,matrix1[2],matrix2);


        
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(test);
        executorService.execute(test2);     
        //executorService.execute(test3);     

        executorService.shutdown();
        executorService.awaitTermination(10,TimeUnit.SECONDS);
        System.out.println("SharedBuffer:");
        System.out.println(buffer);
    }
    //input matrix size calculator
    private static int[] matrixSize(String filename) {
        int row = 0;
        int col = 0;
        try {
            Scanner rowscn = new Scanner(new File(filename));
            while (rowscn.hasNext()) {
                Scanner colscn = new Scanner(rowscn.nextLine());
                col=0;
                while (colscn.hasNext()) {
                    colscn.next();
                    col++;

                }
                
                row++;
                
            }
            
            int[] data = new int[]{row,col};
            return data;
        } catch (FileNotFoundException e) {
        }
    return null;
    }
    //returns @int[][]==>input matrixes from txt files
    private static int[][] matrixGetter(String filename) {
        int[] a = matrixSize(filename);
        int[][] matrix = new int[a[0]][a[1]];
        try {
            Scanner rowscn = new Scanner(new File(filename));
            int rowct = 0;
            int colct = 0;
            while (rowscn.hasNext()) {
                Scanner colscn = new Scanner(rowscn.nextLine());
                while (colscn.hasNext()) {
                    matrix[rowct][colct] = Integer.parseInt(colscn.next());
                    colct++;
                    

                }
                rowct++;
                colct = 0;
            }
            return matrix;
        } catch (FileNotFoundException e) {
        }
    return matrix;
    }
}
