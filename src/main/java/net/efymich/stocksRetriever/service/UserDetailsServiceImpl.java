package net.efymich.stocksRetriever.service;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.dao.UserRepository;
import net.efymich.stocksRetriever.exception.NotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        net.efymich.stocksRetriever.domain.User user = userRepository.findByEmail(email).orElseThrow(() ->
                new NotFoundException(String.format("User with email: %s not found", email)));
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
