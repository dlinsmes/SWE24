import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.*;

import java.util.Scanner;
public class SpotifyAPIDemo {

    public static void main(String[] args) {

        try {
            HttpClient client = HttpClient.newHttpClient();

            String client_id = "";
            String client_secret = "";

            //https://developer.spotify.com/documentation/web-api/tutorials/getting-started#request-an-access-token
            //https://openjdk.org/groups/net/httpclient/recipes.html#post

            URI uri = new URI("https://accounts.spotify.com/api/token");

            //token
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&client_id=" + client_id + "&client_secret=" + client_secret))
                    .header("content-type", "application/x-www-form-urlencoded")
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(response);
            System.out.println(response.body());
            JSONObject resp = new JSONObject(response.body());
            String token = resp.getString("access_token");

            Scanner s = new Scanner(System.in);
            System.out.println("enter artist name");
            String term = s.nextLine();
            term = term.replaceAll(" ", "%20");

            //get request for api calls to search for artist
            uri = new URI("https://api.spotify.com/v1/search?q="+term+"&type=artist");

            request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .header("Authorization", "Bearer " + token)
                    .build();

            response = client.send(request, BodyHandlers.ofString());
            System.out.println(response);
            System.out.println(response.body());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
