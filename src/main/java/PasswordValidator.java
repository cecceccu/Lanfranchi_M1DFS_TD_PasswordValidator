public class PasswordValidator {
    public boolean validateLength(String passwordToTest) {
        return passwordToTest.length()>6;
    }


    public boolean validateDigit(String passwordToTest) {
        return passwordToTest.matches(".*[0-9].*");
    }

    public boolean validateLetter(String passwordToTest) {
        return passwordToTest.matches(".*[a-zA-Z].*");
    }
}
