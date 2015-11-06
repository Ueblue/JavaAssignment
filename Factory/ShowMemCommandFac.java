package Factory;

import java.util.*;
import Command.*;
import Main.X_MEM;
import Member.*;

public class ShowMemCommandFac implements CommandFactory {
	LinkedList<X_MEM_Member> memberList;
	
        @Override
	public void setting(X_MEM x){this.memberList = x.getMemberList();}
        @Override
	public Command create(){return new showMemCommand(memberList);}
}