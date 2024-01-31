package com.example.config.security;

import com.example.api.dto.request.auth.RegisterDto;
import com.example.api.dto.response.auth.AuthDto;
import com.example.persistence.entity.token.Token;
import com.example.persistence.entity.user.Personal;
import com.example.persistence.entity.user.User;
import com.example.persistence.repository.token.TokenRepository;
import com.example.persistence.repository.user.PersonalRepository;
import com.example.persistence.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final PersonalRepository personalRepository;
    private final TokenRepository tokenRepository;
    private final UserRepository<User> userRepository;

    public AuthDto register(RegisterDto registerDto) {
        if (userRepository.existsByLogin(registerDto.getEmail())) {
            throw new RuntimeException("This email had already used");
        }
        Personal personal = new Personal();
        personal.setLogin(registerDto.getEmail());
        personal.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        personal = personalRepository.save(personal);
        String jwtToken = jwtService.generateToken(personal);
        Token token = new Token();
        token.setToken(jwtToken);
        token.setUser(personal);
        tokenRepository.save(token);
        return new AuthDto(jwtToken);
    }

    public AuthDto login(RegisterDto registerDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(registerDto.getEmail(), registerDto.getPassword()));
        var user = userRepository.findByLogin(registerDto.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        Token token = new Token();
        token.setToken(jwtToken);
        token.setUser(user);
        tokenRepository.save(token);
        return new AuthDto(jwtToken);
    }
}
