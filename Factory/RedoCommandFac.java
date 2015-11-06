/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Command.*;
import Main.Memento;
import Main.X_MEM;
import java.util.Stack;

/**
 *
 * @author User
 */
public class RedoCommandFac implements CommandFactory {

    private X_MEM x;

    @Override
    public void setting(X_MEM x) {
        this.x = x;
    }

    @Override
    public Command create() {
        return new RedoCommand(x);
    }

}
