# JWT Authorization Server
JSON Web Token Authorization Server Proof of Concept for the seminary of UTN University Degree in Informatic Systems.

## Instructions 

### Greetings

- Both admin and user have a greeting method to check if the authorization made by our app was correct. Through specific filters that we made in our configuration file, we protected the admin’s methods in case that an user with a different role tries to execute them.

- Endpoint "/user/greeting" returns a greeting from user.

- Endpoint "/admin" returns a greeting from admin.

### User
- Endpoint "/user" expects a request and returns an user from it. From this parameter (request), we will work with the token sent in its header (also, we have to consider that tokens are sent with a bearer string, so that means that when we use it we have to eliminate seven carachters from it). So, in order to get the user, we call JwtTokenUtil where there is a method that returns an username from a token. 


### Login
- Endpoint "/auth" expects a JSON string that represents the user to authenticate. This will have the connection between the authentication and autorization part of the program. Trough this pass, authorization server will send the JSON string waiting for the resoponse of authentication server; if status isn't an 200,it will send an error message and if it is, it will send and ok with the token created from the user
