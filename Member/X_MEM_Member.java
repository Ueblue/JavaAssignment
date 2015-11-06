package Member;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class X_MEM_Member {
    
    public abstract void setAddress(String address);

    public abstract void setId(String Id);

    public abstract void setName(String name);

    public abstract void setExpiryDate(Date expiryDate);

    public abstract void setType(String type);
    
    public String getShortType(){
        String type = getType().replace("_", "");
        if(type.length() > 4)
            return type.substring(0,4);
        else
            return type;
    }

    public abstract String getAddress();

    public abstract String getId();

    public abstract String getName();

    public abstract Date getExpiryDate();

    public abstract String getType();

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String detail = "";
        detail += "\nId : " + getId();
        detail += "\nName : " + getName();
        detail += "\nType : " + getType();
        detail += "\nAddress : " + getAddress();
        detail += "\nExpiryDate : " + sdf.format(getExpiryDate());
        return detail+"\n";
    }
    
    public abstract X_MEM_Member getCopy() throws Exception;
}
