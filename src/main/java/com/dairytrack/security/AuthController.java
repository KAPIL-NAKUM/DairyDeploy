// src/main/java/com/example/jwtauth/controller/AuthController.java
package com.dairytrack.security;

import com.dairytrack.dto.JwtResponseDto;
import com.dairytrack.dto.SignInRequestDto;
import com.dairytrack.dto.SignUpRequestDto;
import com.dairytrack.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequestDto request) {
        authService.signUp(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody SignInRequestDto request) {
        String token = authService.signIn(request);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }
}
