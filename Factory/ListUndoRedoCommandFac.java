/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Command.*;
import Main.X_MEM;

/**
 *
 * @author User
 */
public class ListUndoRedoCommandFac implements CommandFactory {

    private X_MEM x;
    @Override
    public void setting(X_MEM x) {
        this.x = x;
    }

    @Override
    public Command create() {
        return new ListUndoRedoCommand(x);
    }
    
}
