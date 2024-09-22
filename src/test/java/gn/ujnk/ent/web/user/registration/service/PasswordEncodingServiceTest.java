package gn.ujnk.ent.web.user.registration.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link PasswordEncodingService}
 */
public class PasswordEncodingServiceTest {

    private PasswordEncodingService passwordEncodingService = new PasswordEncodingService();

    @DisplayName("Test bcrypt encoding")
    @Test
    void testEncode() {
        String password = "Test2024";
        assertTrue(new BCryptPasswordEncoder().matches( password, passwordEncodingService.encode(password)));
    }

}
