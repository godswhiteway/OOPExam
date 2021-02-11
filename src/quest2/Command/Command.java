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
public interface Command {
      void execute();
      void undo();
      boolean isReversible();
}    

