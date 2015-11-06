/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Main.X_MEM;
import Member.X_MEM_Member;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class UpdateAddressCommand extends Command {

    private LinkedList<X_MEM_Member> memberList;
    private X_MEM_Member x;
    private String address;

    public UpdateAddressCommand(LinkedList<X_MEM_Member> memberList) {
        this.memberList = memberList;
        canUndo = true;
    }

    @Override
    public void run() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Id?");
        String id = input.nextLine();
        x = X_MEM.findMemberById(id);
        address = x.getAddress();
        System.out.println("Enter address?");
        String address = input.nextLine();
        x.setAddress(address);
        System.out.println("Address updated.");
    }

    @Override
    public String getLog() {
        return "Update Address " + x.getId();
    }

    @Override
    public void undo() {
        String temp = x.getAddress();
        x.setAddress(address);
        address = temp;
    }

    @Override
    public void redo() {
        undo();
    }

}
