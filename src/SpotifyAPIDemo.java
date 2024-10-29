import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.*;

public class SpotifyAPIDemo {

    public static void main(String[] args) {

        try {
            HttpClient client = HttpClient.newHttpClient();

            String client_id = "";
            String client_secret = "";

            //build query request uri
            URI uri = new URI("https://accounts.spotify.com/api/token");

            //send the request to the url with the API key for authorization
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&client_id=" + client_id + "&client_secret=" + client_secret))
                    .header("content-type", "application/x-www-form-urlencoded")
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            //response code - tells you if there are any errors
            System.out.println(response);

            //string of the response body - all the information provided
            //by your request
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
