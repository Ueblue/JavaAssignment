package Company.WLTS;

import java.util.*;

public abstract class Client {
    
    private int cid;
    private Date expiryDate;
    private String fullName, homeAddress;
    
    public abstract boolean validate(int cid);
    
    public int getCid() {
        return cid;
    }
    
    public void setCid(int cid) {
        if (this.validate(cid)) {
            this.cid = cid;
        }
    }
    
    public Date getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(Date ex) {
        this.expiryDate = ex;
    }
    
    public String getName() {
        return fullName;
    }
    
    public void setName(String name) {
        this.fullName = name;
    }
    
    public String getAddress() {
        return homeAddress;
    }
    
    public void setAddress(String ha) {
        this.homeAddress = ha;
    }
}
