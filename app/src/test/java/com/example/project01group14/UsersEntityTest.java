package com.example.project01group14;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsersEntityTest {

    @Test
    public void setId() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        user1.setId(1);
        assertEquals(1, user1.getId());
        assertNotEquals(2, user1.getId());
    }

    @Test
    public void setUser_name() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        user1.setUser_name("user");
        assertEquals("user", user1.getUser_name());
        assertNotEquals("username", user1.getUser_name());
    }

    @Test
    public void setUser_first_name() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        user1.setUser_first_name("Martha");
        assertEquals("Martha", user1.getUser_first_name());
        assertNotEquals("Bob", user1.getUser_first_name());
    }

    @Test
    public void setUser_last_name() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        user1.setUser_last_name("Marley");
        assertEquals("Marley", user1.getUser_last_name());
        assertNotEquals("Dickens", user1.getUser_last_name());
    }

    @Test
    public void setUser_password() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        user1.setUser_password("pass");
        assertEquals("pass", user1.getUser_password());
        assertNotEquals("password", user1.getUser_password());
    }

    @Test
    public void getId() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        user1.setId(1);
        assertEquals(1, user1.getId());
    }

    @Test
    public void getUser_name() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        assertEquals("username", user1.getUser_name());
    }

    @Test
    public void getUser_first_name() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        assertEquals("Bob", user1.getUser_first_name());
    }

    @Test
    public void getUser_last_name() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        assertEquals("Dickens", user1.getUser_last_name());
    }

    @Test
    public void getUser_password() {
        UsersEntity user1 = new UsersEntity("username", "Bob", "Dickens", "password");
        assertEquals("password", user1.getUser_password());
    }
}