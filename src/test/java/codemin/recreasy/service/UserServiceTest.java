package codemin.recreasy.service;

import codemin.recreasy.domain.User;
import codemin.recreasy.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class UserServiceTest {

    /**
     * 테스트 요구사항
     * - 회원가입을 성공해야 한다
     */

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;
    @Autowired EntityManager em;

    @Test
    void 회원가입() throws Exception {
        // given
        User user = new User();
        user.setEmail("user@naver.com");

        // when
        Long savedId = userService.join(user);

        // then
        em.flush();
        assertEquals(user, userRepository.findOne(savedId));
    }
}
