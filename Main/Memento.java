/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Command.Command;

public class Memento {

    private Command c;
    private boolean isUndo = true;
    private String log;

    public Memento(Command c) {
        this.c = c;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setIsUndo(boolean isUndo){
        this.isUndo = isUndo;
    }
    public void restore() {
        if(isUndo)
            c.undo();
        else
            c.redo();
    }

    public String toString() {
        return log;
    }
}
