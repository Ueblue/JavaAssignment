package Command;

public abstract class Command {
    protected boolean canUndo;
    protected boolean clearRedo = true;
    protected String log;
    
    public abstract void run() throws Exception ;
    public boolean getCanUndo(){return canUndo;}
    public boolean isClearRedo(){return clearRedo;}
    public abstract String getLog();
    public abstract void undo();
    public abstract void redo();
    
}