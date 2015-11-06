/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Company.AJCS.Member;
import Company.AJCS.PrimaryMember;
import Company.AJCS.CompanyMember;
import Member.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class AJCSMemberFac extends MemberFactory {

    public AJCSMemberFac() {
    }

    @Override
    public X_MEM_Member create() throws Exception {
        askDetail();
        X_MEM_Member x;
        ArrayList<Member> members = new ArrayList<Member>();
        members.add(new CompanyMember());
        members.add(new PrimaryMember());
        
        for (Member m : members) {
            String fullTypeName = null;
            String className = m.getClass().getName().split("\\.")[m.getClass().getName().split("\\.").length - 1];
            System.out.println(className);
            if (className.startsWith(type)) {
                fullTypeName = m.getClass().getName();
                //System.out.println(fullTypeName);
            }
            
            if (fullTypeName != null) {
                Member xm = (Member) Class.forName(fullTypeName).newInstance();
                if (xm.validate(id)) {
                    x = new X_AJCS(xm);
                    x.setId(id);
                    x.setAddress(address);
                    x.setName(name);
                    Date d = new Date();
                    d.setYear(d.getYear() + 1);
                    x.setExpiryDate(d);
                    //System.out.println("return x");
                    return x;
                } else {
                    throw new Exception("id is not vaild.");
                }

            }
        }
        throw new Exception("No type(" + type + ")");
    }
}
