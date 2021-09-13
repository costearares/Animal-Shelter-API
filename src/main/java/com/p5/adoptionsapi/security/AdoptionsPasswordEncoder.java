package com.p5.adoptionsapi.security;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdoptionsPasswordEncoder extends BCryptPasswordEncoder {
}
