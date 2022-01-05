package com.example.demo;

import com.example.demo.common.utils.JwtTokenUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void testToken() throws Exception {
        String userId = "test123";
        String username = "123456";
        String token = JwtTokenUtils.createJWT(userId, username);
        Assertions.assertFalse(JwtTokenUtils.isExpiration(token));
        Assertions.assertEquals(username, JwtTokenUtils.getUsername(token));
        Assertions.assertEquals(userId, JwtTokenUtils.getUserId(token));
    }

}
