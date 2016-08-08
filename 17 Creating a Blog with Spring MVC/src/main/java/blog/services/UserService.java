package blog.services;

import blog.models.User;

import java.util.*;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}