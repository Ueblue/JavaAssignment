package Company.AJCS;

import java.util.*;

public class AdvancedMem {

    private Member[] members = {new CompanyMember(), new PrimaryMember()};

    public Member createMem() {
        Member member = null;
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter id;type;name;address:");
            String data = input.nextLine();
            String id = data.split(";")[0], type = data.split(";")[1],
                    name = data.split(";")[2], address = data.split(";")[3];
            //System.out.println(type);
            String fullTypeName = "";
            for (Member m : members) {
                String className = m.getClass().getName().split("\\.")[m.getClass().getName().split("\\.").length-1];
                //System.out.println(className);
                if (className.startsWith(type)) {
                    fullTypeName = m.getClass().getName();

                }
            }
            member = (Member) Class.forName(fullTypeName).newInstance();
            if(!member.validate(id))
                throw new Exception("id is not valid.");
            member.setId(id);
            member.setName(name);
            member.setPostal(address);
            Date goodTill = new Date();
            member.setGoodTill(goodTill);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return member;
    }

    public Member searchMem(String id) {
        System.out.println("There is no member's id is " + id);
        return null;
    }

    public void updateAddress(String id) {
    }

    public void extendGoodTill(String id) {
    }

    public boolean stillGood(String id) {
        Member m = searchMem(id);
        return m.getGoodTill().compareTo(new Date()) > 0;
    }

}
