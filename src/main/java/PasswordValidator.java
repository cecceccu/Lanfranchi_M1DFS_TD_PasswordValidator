import java.util.ArrayList;

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

    public boolean validateSpecialChar(String passwordToTest) {
        return passwordToTest.matches(".*\\W.*");
    }


    public boolean validateAdminPwd(String passwordToTest) {
        return validateDigit(passwordToTest) && validateLetter(passwordToTest)
                && validateLength(passwordToTest, 10) && validateSpecialChar(passwordToTest);

    }

    public ArrayList<String> invalidPasswordErrors(String passwordToTest, int requiredLength) {
        ArrayList<String> errors = new ArrayList<String>();
        if (!validateLength(passwordToTest, requiredLength))
            errors.add(String.format("Password must be at least %d characters", requiredLength+1));
        if (!validateLetter(passwordToTest))
            errors.add("Password must contain at least one letter");
        if (!validateDigit(passwordToTest))
            errors.add("Password must contain at least one digit");
        if (!validateSpecialChar(passwordToTest))
            errors.add("Password must contain at least one special character");
        return errors;

    }



}
