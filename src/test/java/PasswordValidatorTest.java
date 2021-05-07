import org.junit.jupiter.api.*;

public class PasswordValidatorTest {

    private PasswordValidator validator;
    private String passwordToTest;

    @BeforeAll
    void init(){
        validator = new PasswordValidator();
    }

    @AfterEach
    void cleanUpPwdAfterEach(){
        passwordToTest = null;
    }

    @Test
    void lengthTest(){
        passwordToTest = "3Ffp6";
        Assertions.assertFalse(validator.validateLength(passwordToTest));
    }

    @Test
    void digitTest(){
        passwordToTest = "AgpPolLLzz";
        Assertions.assertFalse(validator.validateDigit(passwordToTest));
    }


    @Test
    void letterTest(){
        passwordToTest = "45896451510518";
        Assertions.assertFalse(validator.validateLetter(passwordToTest));
    }



}
