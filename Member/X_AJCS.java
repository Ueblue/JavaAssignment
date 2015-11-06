package Member;

import java.util.Date;
import Company.AJCS.*;

public class X_AJCS extends X_MEM_Member {

    Member member;
    String type;

    
    
    public X_AJCS(Member m) {
        this.member = m;
        String[] classes = m.getClass().getName().split("\\.");
        setType(classes[classes.length-1]);
    }
    
    public void setAddress(String address) {
        member.setPostal(address);
    }

    public void setId(String Id) {
        member.setId(Id);
    }

    public void setName(String name) {
        member.setName(name);
    }

    public void setExpiryDate(Date expiryDate) {
        member.setGoodTill(expiryDate);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return member.getPostal();
    }

    public String getId() {
        return member.getId();
    }

    public String getName() {
        return member.getName();
    }

    public Date getExpiryDate() {
        return member.getGoodTill();
    }

    public String getType() {
        return type;
    }

    @Override
    public X_MEM_Member getCopy() throws Exception {
        Member m = member.getClass().newInstance();
        X_MEM_Member newM = new X_AJCS(m);
        newM.setAddress(this.getAddress());
        newM.setId(this.getId());
        newM.setName(this.getName());
        newM.setType(this.getType());
        Date d = (Date)this.getExpiryDate().clone();
        newM.setExpiryDate(d);
        return newM;
    }

}
