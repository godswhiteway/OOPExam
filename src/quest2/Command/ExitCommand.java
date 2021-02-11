/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest2.Command;

/**
 *
 * @author akyol
 */
public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void undo() {
        //nothingg to do
    }

    @Override
    public boolean isReversible() {
        return false;
    }
    
}
