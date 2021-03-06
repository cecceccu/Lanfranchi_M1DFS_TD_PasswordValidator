import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

public class PasswordValidatorTest {

    private PasswordValidator validator;
    private String passwordToTest;

    @BeforeEach
    void init(){
        validator = new PasswordValidator();
    }

    @AfterEach
    void cleanUpAfterEach(){
        passwordToTest = null;
        validator = null;
    }

    @Test
    void invalidLengthTest(){
        passwordToTest = "3Ffp6";
        Assertions.assertFalse(validator.validateLength(passwordToTest, 6));
    }

    @Test
    void noDigitsTest(){
        passwordToTest = "AgpPolLLzz";
        Assertions.assertFalse(validator.validateDigit(passwordToTest));
    }


    @Test
    void noLettersTest(){
        passwordToTest = "45896451510518";
        Assertions.assertFalse(validator.validateLetter(passwordToTest));
    }

    @Test
    void validLengthTest(){
        passwordToTest = "aaaaaaaaaaaa";
        Assertions.assertTrue(validator.validateLength(passwordToTest, 6));
    }

    @Test
    void digitsTest(){
        passwordToTest = "a11a2";
        Assertions.assertTrue(validator.validateDigit(passwordToTest));
    }


    @Test
    void lettersTest(){
        passwordToTest = "1a1";
        Assertions.assertTrue(validator.validateLetter(passwordToTest));
    }

    @Test
    void invalidPwdTest(){
        passwordToTest = "a1BC33";
        Assertions.assertFalse(validator.validatePwd(passwordToTest));

    }

    @Test
    void validPwdTest(){
        passwordToTest = "a1BC332e";
        Assertions.assertTrue(validator.validatePwd(passwordToTest));

    }

    @Test
    void noSpecialChars(){
        passwordToTest = "A3g56812ffhjT";
        Assertions.assertFalse(validator.validateSpecialChar(passwordToTest));
    }

    @Test
    void specialChars(){
        passwordToTest = "?hga";
        Assertions.assertTrue(validator.validateSpecialChar(passwordToTest));
    }

    @Test
    void invalidAdminPwdTest(){
        passwordToTest = "A3g4DD56812fhjuT";
        Assertions.assertFalse(validator.validateAdminPwd(passwordToTest));

    }

    @Test
    void validAdminPwdTest(){
        passwordToTest = "A3g4DD568*12fhj*";
        Assertions.assertTrue(validator.validateAdminPwd(passwordToTest));

    }

    @Test
    void invalidPwdWithErrors(){
        passwordToTest = "";
        ArrayList<String> expectedErrors = new ArrayList<>(Arrays.asList("Password must be at least 11 characters",
                "Password must contain at least one letter", "Password must contain at least one digit",
                "Password must contain at least one special character"));
        Assertions.assertEquals(expectedErrors, validator.invalidPasswordErrors(passwordToTest, 10));
    }

    @Test
    void validPwdWithErrors(){
        passwordToTest = "aAbfon15*?ml?LM";
        ArrayList<String> expectedErrors = new ArrayList<String>();
        Assertions.assertEquals(expectedErrors, validator.invalidPasswordErrors(passwordToTest, 10));
    }

}
