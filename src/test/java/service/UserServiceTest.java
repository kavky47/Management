package service;

import models.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Test
    public void testGetAllUsers(){

        //is
        List<User> users = new ArrayList<User>();
        users.add(new User(1,  "admin", "admin"));
        users.add(new User(2, "pablo", "admin"));

        //then
        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestClass = userService.getAllUser();

        //expected
        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testAddUser(){

        //is
        List<User> users = new ArrayList<User>();
        User user = new User(1, "admin", "admin");
        users.add(user);

        //then
        UserServiceImpl userService = new UserServiceImpl(users);
        userService.addUser(user);

        List<User> usersFromTestClass = userService.getAllUser();

        //expected
        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testRemoveUser(){

        //is
        List<User> users = new ArrayList<User>();
        User admin = new User(1, "admin", "admin");
        User adam = new User(2, "adam", "admin");
        users.add(admin);
        users.add(adam);


//        List<User> users1 = new ArrayList<User>();
//        User admin1 = new User(1, "admin", "admin");
//        User adam1 = new User(2, "adam", "admin");
//        users1.add(admin);
//        users1.add(adam);

        UserServiceImpl userService = new UserServiceImpl(new ArrayList<>(users));
        System.out.println(users.size());
        System.out.println(userService.get());
        //then

        userService.removeUserById(2L);
        users.remove(adam);

        System.out.println(users);
        List<User> usersFromTestClass = userService.getAllUser();
        System.out.println(userService);

        //expected
        Assert.assertEquals(users, usersFromTestClass);

    }



}
