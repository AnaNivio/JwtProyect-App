package edu.utn.jwtapplication.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
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
        HashMap<String, String> json = new HashMap<>();
        json.put("message", "Greetings from admin protected method!");
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
