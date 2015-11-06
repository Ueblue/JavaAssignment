/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Command.Command;
import Command.ExtendMembershipCommand;
import Main.X_MEM;
import Member.X_MEM_Member;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class ExtendMembershipCommandFac implements CommandFactory {

    LinkedList<X_MEM_Member> memberList;
    
    @Override
    public void setting(X_MEM x) {
        this.memberList = x.getMemberList();
    }

    @Override
    public Command create() {
        return new ExtendMembershipCommand();
    }
    
}
