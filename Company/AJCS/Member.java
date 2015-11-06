package Company.AJCS;

import java.util.*;

public abstract class Member {
    
    private String id, name, postal;
    private Date goodTill;
    
    public abstract boolean validate(String id);
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        if (this.validate(id)) {
            this.id = id;
        }
    }
    
    public Date getGoodTill() {
        return goodTill;
    }
    
    public void setGoodTill(Date goodTill) {
        this.goodTill = goodTill;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPostal() {
        return postal;
    }
    
    public void setPostal(String postalAddress) {
        this.postal = postalAddress;
    }
    
}
