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

            //https://developer.spotify.com/documentation/web-api/tutorials/getting-started#request-an-access-token
            //https://openjdk.org/groups/net/httpclient/recipes.html#post

            URI uri = new URI("https://accounts.spotify.com/api/token");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&client_id=" + client_id + "&client_secret=" + client_secret))
                    .header("content-type", "application/x-www-form-urlencoded")
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(response);
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
