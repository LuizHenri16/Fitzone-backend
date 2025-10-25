package com.fitzone.FITZONE.Auth;

import com.fitzone.FITZONE.DTO.LoginDTO;
import com.fitzone.FITZONE.Models.User.User;
import com.fitzone.FITZONE.Security.JwtAuthenticationResponse;
import com.fitzone.FITZONE.Security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody  LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);

        User userDetails = (User) authentication.getPrincipal();

        JwtAuthenticationResponse response = new JwtAuthenticationResponse(jwt);
        response.setAccessToken(jwt);
        response.setTokenType("Bearer");
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setAccess(userDetails.getAccess().getValue());

        return ResponseEntity.ok(response);
    }
}
