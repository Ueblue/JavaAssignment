package Factory;
import Command.*;
import Main.X_MEM;

public interface CommandFactory {
	public void setting(X_MEM x);
	public Command create();
	
}