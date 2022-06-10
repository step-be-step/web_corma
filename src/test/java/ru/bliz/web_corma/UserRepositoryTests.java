package ru.bliz.web_corma;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import ru.bliz.user.Role;
import ru.bliz.user.User;
import ru.bliz.user.UserRepo;

import java.util.Collections;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("лучезарный");
        user.setPassword("лучезарный");
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));

        userRepo.save(user);
    }
}
