import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInfor {
    public static final String CHECKPHONE = "[0-9]{9}";
    public static final String CHECKMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean checkPhone(String phone) {
        pattern = Pattern.compile(CHECKPHONE);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean checkMail(String mail) {
        pattern = Pattern.compile(CHECKMAIL);
        matcher = pattern.matcher(mail);
        return matcher.matches();
    }
}
