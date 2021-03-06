/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest2.Command;

import java.util.Stack;

/**
 *
 * @author akyol
 */
public class CommandsInvoker {
    	private Stack<Command> undoStack;
	private Stack<Command> redoStack;
	public CommandsInvoker() {
		undoStack = new Stack<Command>();
		redoStack = new Stack<Command>();
	}
	public void execute(Command any) {

		any.execute();
		if (any.isReversible()){
			undoStack.push(any);
                }
	}
	public void undo() {

		if (undoStack.isEmpty()==false) {
			Command a = undoStack.pop();
			redoStack.push(a);
                        a.undo();
                }
	}


}