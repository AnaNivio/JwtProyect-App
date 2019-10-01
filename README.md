# JWT Authorization Server
JSON Web Token Authorization Server Proof of Concept for the seminary of UTN University Degree in Informatic Systems.

## Instructions in:
### User
- Endpoint "/user" expects a request from where we will obtained (through the header) the information of the actual user.
- Endpoint "/user/greeting" returns a greeting from user.

### Admin
- Endpoint "/admin" returns a greeting from admin.

### Login
- Endpoint "/auth" expects an user. It sends a token to client and, in case if status isn't an 200,it will send an error message.
