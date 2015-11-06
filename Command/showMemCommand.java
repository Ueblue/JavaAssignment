package Command;

import Main.X_MEM;
import java.util.*;
import Member.*;
import java.text.SimpleDateFormat;

public class showMemCommand extends Command {

    LinkedList<X_MEM_Member> memberList;

    public showMemCommand(LinkedList<X_MEM_Member> memberList) {
        this.memberList = memberList;
        canUndo = false;
        clearRedo = false;
    }

    public void run() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("id? (*999 to show all record)");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        if (id.equals("*999")) {
            System.out.println("Expire Date ID       Type   Name     Address");
            for (X_MEM_Member x : memberList) {
                String date = sdf.format(x.getExpiryDate());
                System.out.println(String.format("%s,%s,%s,%s,%s",
                        date, x.getId(), x.getShortType(), x.getName(), x.getAddress()));
            }
            return;
        } else {
            X_MEM_Member x = X_MEM.findMemberById(id);
            System.out.println(x);
            return;
        }
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
