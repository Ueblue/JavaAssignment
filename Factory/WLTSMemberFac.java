/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Company.AJCS.Member;
import Company.WLTS.Client;
import Member.*;
import Company.WLTS.VIP;
import Company.WLTS.VIP_Family;
import java.util.Date;

/**
 *
 * @author User
 */
public class WLTSMemberFac extends MemberFactory {

    public WLTSMemberFac() {
    }

    @Override
    public X_MEM_Member create() throws Exception {
        askDetail();
        X_MEM_Member x;
        Client[] members = {new VIP(), new VIP_Family()};
        for (Client c : members) {
            String fullTypeName = null;
            String className = c.getClass().getName().split("\\.")[c.getClass().getName().split("\\.").length - 1];
            //System.out.println(className);
            if (className.replace("_", "").startsWith(type)) {
                fullTypeName = c.getClass().getName();
            }
            if (fullTypeName != null) {
                Client xc = (Client) Class.forName(fullTypeName).newInstance();
                if (xc.validate(Integer.parseInt(id))) {
                    x = new X_WLTS(xc);
                    x.setId(id);
                    x.setAddress(address);
                    x.setName(name);
                    Date d = new Date();
                    d.setYear(d.getYear() + 1);
                    x.setExpiryDate(d);
                    return x;
                } else {
                    throw new Exception("id is not vaild.");
                }

            }
        }
        throw new Exception("No type(" + type + ")");
    }

}
