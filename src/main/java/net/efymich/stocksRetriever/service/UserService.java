package net.efymich.stocksRetriever.service;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.repository.UserRepository;
import net.efymich.stocksRetriever.domain.User;
import net.efymich.stocksRetriever.dto.RegisterDTO;
import net.efymich.stocksRetriever.exception.DuplicateException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(RegisterDTO request) {
        String email = request.getEmail();
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new DuplicateException(String.format("User with the email address '%s' already exists.",email));
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        User user = User.builder()
                .name(request.getName())
                .email(email)
                .password(hashedPassword)
                .build();

        userRepository.save(user);
    }


}

