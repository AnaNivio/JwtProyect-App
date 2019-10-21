package edu.utn.jwtapplication.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.utn.jwtapplication.models.JwtTokenUtil;
import edu.utn.jwtapplication.models.JwtUser;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private JwtAuthorizationTokenFilter authorizationTokenFilter;
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//
//    ///api/posts?title={value}&body={value}
//    @RequestMapping(value = "login?username={username}&password={password}", method = RequestMethod.GET)
//    public void authorizeUser(@Value("username")String username,@Value("password")String password) {
//        authorizationTokenFilter = new JwtAuthorizationTokenFilter(userDetailsService,);
//    }
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "greeting", method = RequestMethod.GET)
    public ResponseEntity<?> getUserGreeting() {
        HashMap<String, String> json = new HashMap<>();
        json.put("message", "Greetings from user!");
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
