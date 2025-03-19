package org.example.sbwebapp.Service;

import org.example.sbwebapp.Model.User;
import org.example.sbwebapp.dao.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        usersRepository.save(user);
    }

    @Override
    public void addUser(User user) {
        if (user.getId() == null)
            usersRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        usersRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
       usersRepository.deleteAll();
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return user;
    }
}
