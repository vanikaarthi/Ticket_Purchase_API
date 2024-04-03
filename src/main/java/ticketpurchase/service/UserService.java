package ticketpurchase.service;

import ticketpurchase.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUserById(Long userId);

    List<User> getAllUserDetails();

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);

    List<User> getUserBySection(String section);

}
