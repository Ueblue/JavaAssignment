package Company.WLTS;

import java.util.*;
import java.lang.*;

public class ClientCare {

    private Client[] clients = {new VIP(), new VIP_Family()};

    public Client createClient() {
        try {
            Scanner input = new Scanner(System.in);
            String[] types = {"VIP", "VIP_Family"};
            System.out.println("Enter id;type;name;address:");
            String data = input.nextLine();
            String id = data.split(";")[0], type = data.split(";")[1],
                    name = data.split(";")[2], address = data.split(";")[3];

            String fullTypeName = "";
            for (int i = 0;i < types.length;i++) {
                if (types[i].replace("_", "").startsWith(type)) {
                    fullTypeName = clients[i].getClass().getName();
                    break;
                }
            }
            Client c = (Client) Class.forName(fullTypeName).newInstance();
            //System.out.println(fullTypeName);
            if(!c.validate(Integer.parseInt(id)))
                throw new Exception("id is not valid.");
            c.setCid(Integer.parseInt(id));
            c.setAddress(address);
            c.setName(name);
            Date expiryDate = new Date();
            expiryDate.setYear(expiryDate.getYear() + 1);
            c.setExpiryDate(expiryDate);
            return c;
        } catch (NumberFormatException e) {
            System.out.println("Id should be 9 digit.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Client foundClient(int cid){

        return null;
    }

    public void amendAddress(int cid){
        
    }

    public void extendExpiryDate(int cid) throws Exception {


    }

    public boolean isExpired(int cid) throws Exception {
        return true;
    }

}
