package me.dawey.springdance.services;

import me.dawey.springdance.models.User;
import me.dawey.springdance.repos.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(User user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set default role if not specified
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        return userRepository.save(user);
    }
}
