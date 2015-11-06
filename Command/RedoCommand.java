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
public class RedoCommand extends Command{
    private Stack<Memento> undoList;
    private Stack<Memento> redoList;
    
    public RedoCommand(X_MEM x){
        this.redoList = x.getRedoList();
        this.undoList = x.getUndoList();
        this.canUndo = false;
        this.clearRedo = false;
    }
    
    @Override
    public void run() throws Exception {        
        Memento m = redoList.pop();
        undoList.push(m);
        m.setIsUndo(false);
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
