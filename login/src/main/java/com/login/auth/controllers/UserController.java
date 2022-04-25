package com.login.auth.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.login.auth.Model.Duenio;
import com.login.auth.Model.User;
import com.login.auth.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.login.auth.dto.UserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired    RestTemplate restTemplate;

    @PostMapping(value = "/usuarios/registro")
    public Boolean registrosDuenios(@RequestBody Duenio userRequest) {
        User userExist = userRepository.findByUsername(userRequest.getUsername());
        if (userExist == null) {
            User user = new User();
            user.setUsername(userRequest.getUsername());
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            user.setRol("DUENIO");
            userRepository.save(user);
            restTemplate.postForEntity("http://localhost:18080/duenio/add", userRequest, String.class);
            return true;
        }
        return false;
    }

    @PostMapping(value = "/usuarios/inicio")
    public UserDTO login(@RequestBody User userRequest) {
        User userExist = userRepository.findByUsername(userRequest.getUsername());
        if (userExist != null && passwordEncoder.matches(userRequest.getPassword(),userExist.getPassword())){
            String rol = "ROLE_"+userExist.getRol();
            String token = getJWTToken(userRequest.getUsername(),rol);
            UserDTO user = new UserDTO();
            user.setId(userExist.getId());
            user.setUser(userRequest.getUsername());
            user.setRol(userExist.getRol().toUpperCase());
            user.setToken(token);
            return user;
        }
        return null;
    }

    private String getJWTToken(String username,String rol) {
        String secretKey = "secreto";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);

        String token = Jwts
                .builder()
                .setId("petJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 5000000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
