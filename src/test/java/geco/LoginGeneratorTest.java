package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginService loginService;
    private LoginGenerator loginGenerator;

    @Before
    public void fixture() {
        String[] logins =  {"JROL","BPER", "CGUR", "JDU", "JRAL", "JRAL1"};
        loginService = new LoginService(logins);
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void generateLoginForNomAndPrenom() {
        // WHEN
        loginGenerator.generateLoginForNomAndPrenom("Durand",
                "Paul");
        boolean pdurExists = loginService.loginExists("PDUR");
        // THEN
        assertEquals(true, pdurExists);
    }

    @Test
    public void testSuffixeIncremente1() {
        // WHEN
        loginGenerator.generateLoginForNomAndPrenom("Ralling",
                "John");
        boolean jral2Exists = loginService.loginExists("JRAL2");
        // THEN
        assertEquals(true, jral2Exists);
    }

    @Test
    public void testSuffixeIncremente2() {
        // WHEN
        loginGenerator.generateLoginForNomAndPrenom("Rolling",
                "Jean");
        boolean jrol1Exists = loginService.loginExists("JROL1");
        // THEN
        assertEquals(true, jrol1Exists);
    }

    @Test
    public void testAccentsEnleves() {
        // WHEN
        loginGenerator.generateLoginForNomAndPrenom("Dùrand",
                "Paul");
        boolean pdurExists = loginService.loginExists("PDUR");
        // THEN
        assertEquals(true, pdurExists);
    }
}