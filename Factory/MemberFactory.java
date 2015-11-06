/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Member.X_MEM_Member;
import java.util.Scanner;

/**
 *
 * @author User
 */
public abstract class MemberFactory {
    protected String id,type,name,address;
    
    public abstract X_MEM_Member create() throws Exception;
    public void askDetail() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id;type;name;address");
        String[] details = input.nextLine().split(";");
        id = details[0];
        type = details[1];
        name = details[2];
        address = "";
        for(int i = 3;i < details.length;i++)
            address += details[i];
        
    }
    
}
