package Command;

import Main.Memento;
import Main.X_MEM;
import java.util.Stack;

public class ListUndoRedoCommand extends Command {

    private X_MEM x;

    public ListUndoRedoCommand(X_MEM x) {
        this.x = x;
        this.clearRedo = false;
    }

    @Override
    public void run() throws Exception {
        Stack<Memento> list = x.getUndoList();
        System.out.println("Undo List:");
        for (Memento m : list) {
            if (!m.toString().isEmpty()) {
                System.out.println(m);
            }
        }
        list = x.getRedoList();
        System.out.println("Redo List:");
        for (int i = list.size()-1; i >= 0; i--) {
            Memento m = list.elementAt(i);
            if (!m.toString().isEmpty()) {
                System.out.println(m);
            }
        }

    }

    @Override
    public String getLog() {
        return "";
    }

    @Override
    public void undo() {
        
    }

    @Override
    public void redo() {
        
    }

}
