/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest2.Command;

import java.util.Arrays;
import javax.swing.JTextField;
import quest2.SingletonRandomArrays;
import quest2.Sort;

/**
 *
 * @author akyol
 */
public class SortCommand implements Command {

    private final JTextField setted;
    private final String old;
    private final Sort sort;
    private final SingletonRandomArrays singleton = SingletonRandomArrays.getInstance();
    public SortCommand(JTextField set,Sort any){
        
        this.old = Arrays.toString(this.singleton.array);
        this.sort = any;
        this.setted = set;        
        
    }
    @Override
    public void execute() {   
        int[] copy = this.singleton.array.clone();


        sort.sort(copy);
        setted.setText(Arrays.toString(copy));
        
        copy = this.singleton.array.clone();
    }

    @Override
    public void undo() {
        setted.setText(old);
    }

    @Override
    public boolean isReversible() {
        return true;
    }
    
}
