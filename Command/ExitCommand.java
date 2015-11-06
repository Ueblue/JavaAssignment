package Command;

public class ExitCommand extends Command {

    public void run() throws Exception {
        System.out.println("Leaving System...");
        System.exit(1);
    }

    @Override
    public String getLog() {
        return null;
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
