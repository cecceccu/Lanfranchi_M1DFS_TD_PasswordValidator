import org.junit.jupiter.api.*;

public class PasswordValidatorTest {

    private static PasswordValidator validator;
    private String passwordToTest;

    @BeforeAll
    static void init(){
        validator = new PasswordValidator();
    }

    @AfterEach
    void cleanUpPwdAfterEach(){
        passwordToTest = null;
    }

    @Test
    void invalidLengthTest(){
        passwordToTest = "3Ffp6";
        Assertions.assertFalse(validator.validateLength(passwordToTest));
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
    void lengthTest(){
        passwordToTest = "aaaaaaaaaaaa";
        Assertions.assertTrue(validator.validateLength(passwordToTest));
    }

    @Test
    void digitsTest(){
        passwordToTest = "a1a";
        Assertions.assertTrue(validator.validateDigit(passwordToTest));
    }


    @Test
    void lettersTest(){
        passwordToTest = "1a1";
        Assertions.assertTrue(validator.validateLetter(passwordToTest));
    }



}
