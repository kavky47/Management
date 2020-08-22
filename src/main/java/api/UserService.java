package api;

import models.User;

import java.util.List;

public interface UserService {

        List<User> getAllUser();
        public void addUser(User user);
        public void removeUserById(Long userId);

}
