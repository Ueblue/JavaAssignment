/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Factory.*;
import Main.X_MEM;
import Member.*;
import Menu.Menu;
import java.util.*;

/**
 *
 * @author User
 */
public class CreateMemCommand extends Command {

    private LinkedList<X_MEM_Member> memberList;
    private X_MEM_Member m;

    public CreateMemCommand(LinkedList<X_MEM_Member> memberList) {
        this.memberList = memberList;
        canUndo = true;
    }

    @Override
    public void run() throws Exception {
        Scanner input = new Scanner(System.in);
        String code = "(";
        for (String c : Menu.COMPANYS) {
            code += c + ",";
        }
        code = code.substring(0, code.length() - 1) + ")";
        System.out.println("Enter Company Code:" + code);
        String companyCode = input.nextLine();
        MemberFactory mf = (MemberFactory) Class.forName("Factory." + companyCode.toUpperCase() + "MemberFac").newInstance();
        m = mf.create();
        try {
            X_MEM.findMemberById(m.getId());
        } catch (Exception e) {
            memberList.add(m);
            System.out.println("Member added");
            return;
        }
        throw new Exception("UserID(" + m.getId()+") is used.\nPlease use another ID.");
    }

    @Override
    public String getLog() {
        return "Create " + m.getId();
    }

    @Override
    public void undo() {
        memberList.remove(m);
    }

    @Override
    public void redo() {
        memberList.add(m);
    }
}
