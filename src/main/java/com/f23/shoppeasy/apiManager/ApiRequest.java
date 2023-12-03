package com.f23.shoppeasy.apiManager;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.ArrayList;
import java.util.List;

public class ApiRequest {
    private List<Coordinate> coordinates;
    
    public ApiRequest(double... coordinates) {
        if (coordinates.length % 2 != 0) {
            throw new IllegalArgumentException("Coordinates must be paired");
        }
        
        this.coordinates = new ArrayList<>();

        for (int i = 0; i <= coordinates.length / 2; i += 2) {
            this.coordinates.add(new Coordinate(coordinates[i], coordinates[i + 1]));
        }
    }
    
    public String getResponse() {
        String url = "http://router.project-osrm.org/route/v1/driving/";
        
        for (Coordinate coordinate : this.coordinates) {
            url += coordinate.toString();
        }

        url = url.substring(0, url.length() - 1);

        String retval;
        
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("overview", "false")
                    .timeout(Duration.of(5, SECONDS))
                    .GET()
                    .build();
            
            HttpResponse response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body().toString());
            
            float duration = root.at("/routes/0/legs/0/duration").floatValue();
            retval = String.format("%.2f", duration / 60);
        } catch (Exception e) {
            e.getMessage();
            return "";
        }
        
        return retval;
    }
}
