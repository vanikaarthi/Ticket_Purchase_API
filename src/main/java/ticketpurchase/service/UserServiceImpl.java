package ticketpurchase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ticketpurchase.entity.User;
import ticketpurchase.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUserDetails() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            user.setId(userId);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getUserBySection(String section) {
        return userRepository.getUserBySection(section);
    }
}
