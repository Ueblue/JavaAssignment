package Main;

import Menu.Menu;
import java.util.*;
import Member.*;
import Command.*;
import Factory.*;

public class X_MEM {

    static LinkedList<X_MEM_Member> memberList;
    private Scanner input;
    private String menu = "", cmdsDescription = "";
    private Stack<Memento> undoList = new Stack<Memento>();
    private Stack<Memento> redoList = new Stack<Memento>();
    private Memento m;
    
    public X_MEM() {
        memberList = new LinkedList<X_MEM_Member>();
        input = new Scanner(System.in);
        setupMenu();
    }

    public void start() {
        while (true) {
            try {
                System.out.println("\nX Mem Management System");
                System.out.println("Please Enter Command:" + menu);
                System.out.println(cmdsDescription);
                String option = input.nextLine();
                System.out.println();

                for (int i = 0; i < Menu.KEYS.length; i++) {
                    if (option.equals(Menu.KEYS[i])) {
                        CommandFactory cf = (CommandFactory) Class.forName("Factory." + Menu.CMDFACTORY[i]).newInstance();
                        cf.setting(this);
                        Command c = cf.create();
                        m = new Memento(c);
                        c.run();
                        if (c.getCanUndo()) {
                            m.setLog(c.getLog());
                            undoList.add(m);
                        }
                        if(c.isClearRedo())
                            redoList.clear();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setupMenu() {
        menu = "[";
        for (int i = 0; i < Menu.KEYS.length; i++) {
            menu += Menu.KEYS[i] + " ";
            if (i < Menu.KEYS.length - 1) {
                menu += "| ";
            }

            cmdsDescription += Menu.KEYS[i] + " = " + Menu.DESCRIPTION[i] + ", ";

        }
        menu += "]";
        if (cmdsDescription.endsWith(", ")) {
            cmdsDescription = cmdsDescription.substring(0, cmdsDescription.length() - 2) + "\n";
        }
    }

    public LinkedList<X_MEM_Member> getMemberList() {
        return memberList;
    }

    public Stack<Memento> getUndoList() {
        return undoList;
    }
    
    public Stack<Memento> getRedoList(){
        return redoList;
        
    }

    public static X_MEM_Member findMemberById(String id) throws Exception {
        for (X_MEM_Member x : memberList) {
            if (x.getId().equals(id)) {
                return x;
            }
        }
        throw new Exception(String.format("id(%s) not found.", id));
    }
}
