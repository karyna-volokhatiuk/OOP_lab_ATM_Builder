package builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .firstName("Karyna")
                .gender("w")
                .age(18)
                .lastName("Volokhatiuk")
                .weight(55)
                .occupation("UCU")
                .build();
    }

    @Test
    void testToString() {
        assertEquals("User(firstName=Karyna, lastName=Volokhatiuk, occupations=[UCU], gender=w, age=18, weight=55)",
                user.toString());
    }

}