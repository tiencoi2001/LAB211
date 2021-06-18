
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vu Duc Tien
 */
public class DataInput {

    public int inputChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String raw = scanner.nextLine().trim();
            raw = raw.replaceAll("\\s+", " ");
            if (!raw.isEmpty()) {
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.print("Choice must in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Choice must be an integer, enter again: ");
                }
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }

    public void getNotification(Locale language, String keyword) {
        ResourceBundle rb = ResourceBundle.getBundle("language/" + language, language);
        String value = rb.getString(keyword);
        System.out.print(value);
    }

    public String inputAccount(Locale language) {
        Scanner sc = new Scanner(System.in);
        String acc;
        while (true) {
            getNotification(language, "enterAcc");
            acc = sc.nextLine().trim();
            acc = acc.replaceAll("\\s+", " ");
            if (acc.isEmpty()) {
                getNotification(language, "errAccEmpty");
                System.out.println("");
            } else {
                Pattern p = Pattern.compile("^[0-9]{10}$");
                if (p.matcher(acc).find()) {
                    break;
                }
                getNotification(language, "errInputAcc");
                System.out.println("");
            }
        }
        return acc;
    }

    public String checkPassword(Locale language) {
        Scanner in = new Scanner(System.in);
        String pass;
        while (true) {
            getNotification(language, "enterPassword");
            pass = in.nextLine().trim();
            pass = pass.replaceAll("\\s+", " ");
            if (pass.isEmpty()) {
                getNotification(language, "errPasswordEmpty");
                System.out.println("");
            } else {
                Pattern p = Pattern.compile("^[0-9A-Za-z]{8,31}$");
                Pattern pDigit = Pattern.compile("^[0-9A-Za-z]*[0-9]+[0-9A-Za-z]*");
                Pattern pLetter = Pattern.compile("^[0-9A-Za-z]*[A-Za-z]+[0-9A-Za-z]*");

                if (p.matcher(pass).find() && pDigit.matcher(pass).find()
                        && pLetter.matcher(pass).find()) {
                    break;
                }
                getNotification(language, "errInputPassword");
                System.out.println("");
            }
        }
        return pass;
    }

    public String createCaptcha() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int index
                    = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public boolean checkCaptcha(Locale language) {
        Scanner sc = new Scanner(System.in);
        while (true) {
        String captcha = createCaptcha();
        System.out.println("Captcha: " + captcha);
        getNotification(language, "enterCaptcha");
        String captchaInput = sc.nextLine().trim();
            captchaInput = captchaInput.replaceAll("\\s+", " ");
            if (captchaInput.isEmpty()) {
                getNotification(language, "errCaptcha");
                System.out.println("");
            } else {
                if (!captchaInput.equals(captcha)) {
                    getNotification(language, "errCaptcha");
                    System.out.println("");
                } else {
                    break;
                }
            }
        }
        return true;
    }
}
