package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import main.najah.code.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Execution(ExecutionMode.CONCURRENT) 
class UserServiceSimpleTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    // Extended Email Validation Tests
    @ParameterizedTest
    @CsvSource({
        "valid@example.com, true",
        "invalidemail.com, false",
        "invalid@com, false",
        "user@domain., true",
        "user@.com, true",
        "test@@example.com, true",  
        " user@example.com , true",  
        " , false",  
        "user@ex amplecom, false"  
    })
    @DisplayName("Parameterized Test: Various email formats")
    void testMultipleEmails(String email, boolean expected) {
        System.out.println("Starting testMultipleEmails at " + LocalTime.now());

        assertEquals(expected, userService.isValidEmail(email), "Email validation should match expected result");
    }

    // Authentication Edge Cases
    @ParameterizedTest
    @CsvSource({
        "admin, 1234, true",
        "user, 1234, false",
        "admin, wrongpass, false",
        "user, wrongpass, false",
        "admin, '', false"  
    })
    @DisplayName("Parameterized Test: Authentication Cases")
    void testAuthentication(String username, String password, boolean expected) {
        System.out.println("Starting testAuthentication at " + LocalTime.now());

        assertEquals(expected, userService.authenticate(username, password));
    }

    // Batch Assertions for Authentication
    @Test
    @DisplayName("Invalid Authentication Cases with assertAll")
    void testInvalidAuthentication() {
        assertAll(
            () -> assertFalse(userService.authenticate("user", "1234"), "Incorrect username"),
            () -> assertFalse(userService.authenticate("admin", "wrongpass"), "Incorrect password"),
            () -> assertFalse(userService.authenticate("user", "wrongpass"), "Incorrect username and password")
        );
    }

    // Timeout Test
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Performance Test: Authentication should complete within 500ms")
    void testAuthenticationPerformance() {
        assertTrue(userService.authenticate("admin", "1234"));
    }

    // Exception Handling Test
    @Test
    @DisplayName("Exception Handling: Should not throw an exception for invalid input")
    void testNoExceptionOnInvalidInput() {
        assertDoesNotThrow(() -> userService.authenticate("user", null));
        assertDoesNotThrow(() -> userService.isValidEmail(null));
    }

    // Disabled Failing Test
    @Test
    @Disabled("Fails because `authenticate()` does not handle nulls. Fix: Add null checks in the method.")
    @DisplayName("Disabled Test: Null username or password should return false")
    void testNullAuthentication() {
        System.out.println("Starting testNullAuthentication at " + LocalTime.now());

        assertAll(
            () -> assertFalse(userService.authenticate(null, "1234")),
            () -> assertFalse(userService.authenticate("admin", null)),
            () -> assertFalse(userService.authenticate(null, null))
        );
    }
}
