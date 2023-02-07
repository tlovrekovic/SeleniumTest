import java.util.Random;

public class RandomGenerator {
    private static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*";
    private static final int PASSWORD_LENGTH = 8;
    private static final int ID_LENGTH = 8;
    private static final int FIRST_NAME_LENGTH = 8;
    private static final int LAST_NAME_LENGTH = 10;
    private static final int EMAIL_LENGTH = 20;
    private static final int PHONE_LENGTH = 10;
    private static final int ADDRESS_LENGTH = 20;
    private static final int CITY_LENGTH = 10;
    private static final int STATE_LENGTH = 2;
    private static final int ZIP_LENGTH = 5;
    private static final int COUNTRY_LENGTH = 10;

    private static final Random random = new Random();

    public static String generateUserID() {
        return generateRandomString(ID_LENGTH, NUMBERS);
    }

    public static String generatePassword() {
        return generateRandomString(PASSWORD_LENGTH, LOWERCASE_ALPHABET + UPPERCASE_ALPHABET + NUMBERS + SPECIAL_CHARACTERS);
    }

    public static String generateRepeatPassword() {
        return generatePassword();
    }

    public static String generateFirstName() {
        return generateRandomString(FIRST_NAME_LENGTH, LOWERCASE_ALPHABET + UPPERCASE_ALPHABET);
    }

    public static String generateLastName() {
        return generateRandomString(LAST_NAME_LENGTH, LOWERCASE_ALPHABET + UPPERCASE_ALPHABET);
    }

    public static String generateEmail() {
        return generateRandomString(EMAIL_LENGTH, LOWERCASE_ALPHABET + NUMBERS) + "@example.com";
    }

    public static String generatePhone() {
        return generateRandomString(PHONE_LENGTH, NUMBERS);
    }

    public static String generateAddress1() {
        return generateRandomString(ADDRESS_LENGTH, LOWERCASE_ALPHABET + UPPERCASE_ALPHABET + NUMBERS + " ");
    }

    public static String generateAddress2() {
        return generateRandomString(ADDRESS_LENGTH, LOWERCASE_ALPHABET + UPPERCASE_ALPHABET + NUMBERS + " ");
    }

    public static String generateCity() {
        return generateRandomString(CITY_LENGTH, LOWERCASE_ALPHABET + UPPERCASE_ALPHABET);
    }
    public static String generateState() {
            return generateRandomString(STATE_LENGTH, UPPERCASE_ALPHABET);
        }

        public static String generateZip() {
            return generateRandomString(ZIP_LENGTH, NUMBERS);
        }

        public static String generateCountry() {
            return generateRandomString(COUNTRY_LENGTH, LOWERCASE_ALPHABET + UPPERCASE_ALPHABET);
        }

        private static String generateRandomString(int length, String characters) {
            char[] text = new char[length];
            for (int i = 0; i < length; i++) {
                text[i] = characters.charAt(random.nextInt(characters.length()));
            }
            return new String(text);
        }
    }
