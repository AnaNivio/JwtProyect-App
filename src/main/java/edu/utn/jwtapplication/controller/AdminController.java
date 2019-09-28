package edu.utn.jwtapplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AdminController {

    //In WbeConfiguration, it's calling admin LIKE THIS: ADMIN
//    @RequestMapping(value = "admin", method = RequestMethod.GET)
//    public void getAuthenticatedUser(HttpServletRequest request) {
//
//
//    }

    @RequestMapping(value = "admin",method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getProtectedGreeting() {
        return ResponseEntity.ok("Greetings from admin protected method!");
    }
}
