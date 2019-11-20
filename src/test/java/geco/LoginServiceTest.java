package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void testLoginExists() {
        // GIVEN
        String[] logins = {"422404", "ElyanPoujol", "RobertPaté"};
        LoginService loginService = new LoginService(logins);
        // WHEN
        boolean robertExists = loginService.loginExists("RobertPaté");
        boolean anotherGuyExists = loginService.loginExists("AnotherGuy");
        // THEN
        assertEquals(true, robertExists);
        assertEquals(false, anotherGuyExists);
    }

    @Test
    public void testAddLogin() {
        // GIVEN
        String[] logins = {"422404", "ElyanPoujol", "RobertPaté"};
        LoginService loginService = new LoginService(logins);
        String anotherGuyLogin = "AnotherGuy";
        // WHEN
        boolean before = loginService.loginExists(anotherGuyLogin);
        loginService.addLogin(anotherGuyLogin);
        boolean after = loginService.loginExists(anotherGuyLogin);
        // THEN
        assertEquals(false, before);
        assertEquals(true, after);
    }

    @Test
    public void testFindAllLogins() {
        // GIVEN
        String[] logins = {"422404", "ElyanPoujol", "RobertPaté"};
        String[] expectedLogins = {"422404", "ElyanPoujol", "RobertPaté"};
        LoginService loginService = new LoginService(logins);
        // WHEN
        List<String> returnedLogins = loginService.findAllLogins();
        // THEN
        assertArrayEquals(expectedLogins,
                returnedLogins.toArray(new String[] {}));
    }

    @Test
    public void testFindAllLoginsStartingWith() {
        // GIVEN
        String[] logins = {"ElyanPoujol", "Ellie", "RobertPaté"};
        String[] expectedLogins1 = {"Ellie", "ElyanPoujol"};
        String[] expectedLogins2 = {};
        LoginService loginService = new LoginService(logins);
        // WHEN
        List<String> returnedLogins1 = loginService
                .findAllLoginsStartingWith("El");
        List<String> returnedLogins2 = loginService
                .findAllLoginsStartingWith("Qu");
        // THEN
        assertArrayEquals(expectedLogins1,
                returnedLogins1.toArray(new String[] {}));
        assertArrayEquals(expectedLogins2,
                returnedLogins2.toArray(new String[] {}));
    }
}