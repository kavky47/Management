package service;

import api.UserService;
import models.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users;

    public UserServiceImpl(){
       //this.users = new ArrayList<User>();
        this.users = new LinkedList<>(users);
    }

    public UserServiceImpl(List<User> users){
        this.users = users;
    }

    public List<User> getAllUser() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUserById(Long userId) {

        for(int i = 0; i < users.size(); i++){

            if(users.get(i).getId() == userId){
                users.remove(i);
                break;
            }
        }
    }

    public int get(){
        return users.size();
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "users=" + users +
                '}';
    }
}
