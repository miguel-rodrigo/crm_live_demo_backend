package com.bootcamp4.CRMLiveDemo.auth;

import jakarta.servlet.http.Cookie;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @PostMapping("login")
    public ResponseEntity<String> getLoginToken(@RequestBody @NotNull Credentials credentials) {
        if (credentials.getUserName().equals("Miguel") &&
                credentials.getPassword().equals("Hola123")) {
            ResponseCookie cookie = ResponseCookie.from("IDTOKEN", "all_gucci")
                    .httpOnly(true)
                    .secure(true)
                    .maxAge(3600)
                    .domain("*")
                    .build();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .body("all_gucci");
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid user/password");
        }
    }
}
