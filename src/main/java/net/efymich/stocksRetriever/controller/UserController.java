package net.efymich.stocksRetriever.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.authentication.helper.JWTHelper;
import net.efymich.stocksRetriever.dto.LoginDTO;
import net.efymich.stocksRetriever.dto.LoginResponseDTO;
import net.efymich.stocksRetriever.dto.RegisterDTO;
import net.efymich.stocksRetriever.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUpUser(@Valid @RequestBody RegisterDTO request) {
        userService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String token = JWTHelper.generateToken(request.getEmail());
        return ResponseEntity.ok(new LoginResponseDTO(request.getEmail(),token));
    }

}
