/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest2;

import java.util.Random;

/**
 *
 * @author akyol
 */
public class SingletonRandomArrays {

    private static SingletonRandomArrays instance;
    private static Random a = new Random();
    public int[] array;

    private SingletonRandomArrays() {
        this.array = new int[a.nextInt(100)];
        for(int i=0;i<array.length;i++){
            array[i] = a.nextInt(1000);
        }
    }

    public static SingletonRandomArrays getInstance() {
        if (instance == null) {
            instance = new SingletonRandomArrays();
        }
        return instance;
    }
}

