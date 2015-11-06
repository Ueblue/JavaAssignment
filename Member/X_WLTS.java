package Member;

import java.util.Date;
import Company.WLTS.*;

public class X_WLTS extends X_MEM_Member {

    Client member;
    String type;

    public X_WLTS(Client m) {
        this.member = m;
        String[] classes = m.getClass().getName().split("\\.");
        setType(classes[classes.length-1]);
    }

    public void setAddress(String address) {
        member.setAddress(address);
    }

    public void setId(String Id) {
        member.setCid(Integer.parseInt(Id));
    }

    public void setName(String name) {
        member.setName(name);
    }

    public void setExpiryDate(Date expiryDate) {
        member.setExpiryDate(expiryDate);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return member.getAddress();
    }

    public String getId() {
        return member.getCid() + "";
    }

    public String getName() {
        return member.getName();
    }

    public Date getExpiryDate() {
        return member.getExpiryDate();
    }

    public String getType() {
        return type;
    }
    
    @Override
    public X_MEM_Member getCopy() throws Exception {
        Client m = member.getClass().newInstance();
        X_MEM_Member newM = new X_WLTS(m);
        newM.setAddress(this.getAddress());
        newM.setId(this.getId());
        newM.setName(this.getName());
        newM.setType(this.getType());
        Date d = (Date)this.getExpiryDate().clone();
        newM.setExpiryDate(d);
        return newM;
    }
}
