package Company.WLTS;

public class VIP extends Client {

    public boolean validate(int cid) {
        int sum = 0;

        if ((cid + "").startsWith("3") && (cid + "").length() == 9) {
            for (int i = 0; i < 9; i++) {
                sum += Integer.parseInt((cid + "").charAt(i) + "");
            }
            if (sum % 6 == 0) {
                return true;
            }
        }
        return false;
    }

}
