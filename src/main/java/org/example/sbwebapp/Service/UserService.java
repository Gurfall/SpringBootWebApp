package org.example.sbwebapp.Service;

import org.example.sbwebapp.Model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void updateUser(User user);
    public void addUser(User user);
    public void deleteUserById(int id);
    public void deleteAllUsers();
    public User getUserById(int id);
}
