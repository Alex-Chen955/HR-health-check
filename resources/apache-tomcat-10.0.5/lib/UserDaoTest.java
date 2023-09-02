package comc.proj.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao dao=new UserDao();
    @Test
    void logIn() {
        assertEquals(1,dao.logIn("Alex","slower"));
        assertEquals(0,dao.logIn("Alex","607"));
        assertEquals(1,dao.logIn("Rain","606"));
    }
}