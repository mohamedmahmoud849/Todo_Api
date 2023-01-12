package com.example.todo_api.controller;



import com.example.todo_api.model.authenticationRequest;
import com.example.todo_api.model.authenticationResponse;
import com.example.todo_api.model.registerRequest;
import com.example.todo_api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class authControl {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<authenticationResponse> register(@RequestBody registerRequest request){
      return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<authenticationResponse> authenticate(@RequestBody authenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
