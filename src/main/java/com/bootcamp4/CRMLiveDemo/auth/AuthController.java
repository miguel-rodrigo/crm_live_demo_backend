package com.bootcamp4.CRMLiveDemo.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @PostMapping("login")
    public ResponseEntity<String> getLoginToken(@RequestBody Credentials credentials) {
        if (credentials.getUserName().equals("Miguel") && credentials.getPassword().equals("Hola123")) {
            return ResponseEntity.status(HttpStatus.OK).body("all_gucci");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user/password");
        }
    }
}
