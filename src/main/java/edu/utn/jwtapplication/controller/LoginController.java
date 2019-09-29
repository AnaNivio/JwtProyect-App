package edu.utn.jwtapplication.controller;

import edu.utn.jwtapplication.models.JwtAuthenticationResponse;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class LoginController {
    @Value("${jwt.authserver}")
    private String authserver;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody String json) {
        OkHttpClient client = new OkHttpClient();
        Response response;
        String responseBody = "";
        int responseStatus = 500;

        try {
            // Preapare body for POST to authorization server
            okhttp3.RequestBody body = okhttp3.RequestBody.create(JSON, json);

            // Make a POST request to authorization server
            Request request = new Request.Builder()
                    .url(authserver)
                    .post(body)
                    .build();

            Call call = client.newCall(request);
            response = call.execute();

            responseBody = response.body().string();
            responseStatus = response.code();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Send token to client, and error message if status is not 200
        return ResponseEntity.status(responseStatus).body(responseBody);
    }
}
