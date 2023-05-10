package user_data;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    private static final int SYMBOLS_IN_EMAIL = 10;
    private static final int SYMBOLS_IN_PASSWORD = 7;
    private static final int SYMBOLS_IN_COMMENT = 8;
    private static final String EMAIL = "@gmail.com";


    public static User getValidUser() {
        return new User(generateEmail(), generatePassword(), generateFirstName());
    }


    public static String generateEmail() {
        return RandomStringUtils.randomAlphabetic(SYMBOLS_IN_EMAIL).toLowerCase() + EMAIL;
    }

    public static String generatePassword() {
        return RandomStringUtils.randomAlphabetic(SYMBOLS_IN_PASSWORD).toLowerCase();
    }

    public static String generateFirstName() {
        return RandomStringUtils.randomAlphabetic(SYMBOLS_IN_COMMENT).toLowerCase();
    }

}
