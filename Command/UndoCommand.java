/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Main.Memento;
import Main.X_MEM;
import java.util.Stack;

/**
 *
 * @author User
 */
public class UndoCommand extends Command{
    Stack<Memento> s;
    X_MEM x;
            
    public UndoCommand(X_MEM x){
        this.x = x;
        this.s = x.getUndoList();
        canUndo = false;
        clearRedo = false;
    }
    
    @Override
    public void run() throws Exception {
        Memento m = s.pop();
        x.getRedoList().push(m);
        m.setIsUndo(true);
        m.restore();
    }

    @Override
    public String getLog() {
        return "";
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
