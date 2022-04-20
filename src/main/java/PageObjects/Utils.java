package PageObjects;

import java.util.Random;

public class Utils {

    public static String generateRandomEmail(){
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder rndEmail = new StringBuilder();
        Random rnd = new Random();
        while (rndEmail.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            rndEmail.append(CHARS.charAt(index));
        }
        String newEmail = rndEmail.toString();
        return newEmail;
    }
}