/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Main.X_MEM;
import Member.X_MEM_Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ExtendMembershipCommand extends Command {

    private X_MEM_Member m;

    public ExtendMembershipCommand() {
        canUndo = true;
    }

    @Override
    public void run() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id? ");
        String id = input.nextLine();
        m = X_MEM.findMemberById(id);
        m.getExpiryDate().setYear(m.getExpiryDate().getYear() + 1);
        System.out.println("Membership extended:");
        System.out.println(sdf.format(m.getExpiryDate()) + "," + m.getId() + "," + m.getType() + "," + m.getName() + "," + m.getAddress());
    }

    @Override
    public String getLog() {
        return "Extend Membership " + m.getId();
    }

    @Override
    public void undo() {
        Date d = m.getExpiryDate();
        d.setYear(d.getYear()-1);
        m.setExpiryDate(d);
    }

    @Override
    public void redo() {
        Date d = m.getExpiryDate();
        d.setYear(d.getYear()+1);
        m.setExpiryDate(d);
    }

}
