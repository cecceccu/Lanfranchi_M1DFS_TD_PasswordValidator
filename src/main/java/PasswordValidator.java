public class PasswordValidator {
    public boolean validateLength(String passwordToTest, int length) {
        return passwordToTest.length()>length;
    }


    public boolean validateDigit(String passwordToTest) {
        return passwordToTest.matches(".*[0-9].*");
    }

    public boolean validateLetter(String passwordToTest) {
        return passwordToTest.matches(".*[a-zA-Z].*");
    }

    public boolean validatePwd(String passwordToTest) {
        return validateDigit(passwordToTest) && validateLetter(passwordToTest) && validateLength(passwordToTest, 6);
    }

    public boolean validateSpecialChars(String passwordToTest) {
        return passwordToTest.matches(".*\\W.*");
    }


    public boolean validateAdminPwd(String passwordToTest) {
        return validateDigit(passwordToTest) && validateLetter(passwordToTest)
                && validateLength(passwordToTest, 10) && validateSpecialChars(passwordToTest);

    }
}
