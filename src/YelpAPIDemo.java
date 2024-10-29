import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.*;


public class YelpAPIDemo {

    public static void main(String [] args) {

        try {
            HttpClient client = HttpClient.newHttpClient();

            String API_KEY = "";

            String term = "mcdonalds";
            String location = "San%20juan%20capistrano"; //%20 for spaces

            //build query request uri
            URI uri = new URI("https://api.yelp.com/v3/businesses/search?term=" + term
                + "&location=" + location);

            //send the request to the url with the API key for authorization
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .header("authorization", "Bearer " + API_KEY)
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            //response code - tells you if there are any errors
            System.out.println(response);

            //string of the response body - all the information provided
            //by your request
            System.out.println(response.body());

            System.out.println();

            //response body is returned in JSON format (javascript object notation)

            JSONObject responseObject = new JSONObject(response.body());
            System.out.println(responseObject);

            //keys are like indices - labels for the data
            System.out.println("keys in responseObject: " + responseObject.keySet());

            //get the value stored to the total key
            System.out.println("total: " + responseObject.get("total"));

            //the value stored in region is another JSON object (there are curly braces around it)
            System.out.println("region: " + responseObject.get("region"));

            JSONObject region = responseObject.getJSONObject("region");
            System.out.println(region);
            System.out.println(region.get("center"));

            //center is another json object (there are curly braces around it)
            System.out.println(region.getJSONObject("center").get("latitude"));

            //businesses is a JSONArray (square brackets instead of curly braces)
            JSONArray businesses = responseObject.getJSONArray("businesses");
            System.out.println(businesses);

            //get the 0th element of the array
            System.out.println(businesses.get(0));

            //System.out.println(businesses.get(0).get("name"));

            //the array holds JSON objects - need to cast
            JSONObject b0 = (JSONObject) businesses.get(10);

            //get the name of the 0th business - has curly braces
            System.out.println(b0);

            System.out.println(b0.get("name"));

            System.out.println("number of results: " + businesses.length());

            //save business name to a string variable
            //String n = b0.get("name");

            //get() returns an object - use getType()
            String n = b0.getString("name");

            //use debugger to see attributes and organization of b0

            //check if an object has a particular attribute:
            if (b0.has("image_url")) {
                System.out.println(b0.get("image_url"));
            }


            //loop through each object in businesses
            for (int i = 0; i < businesses.length(); i++) {
                //JSONObject j = businesses.getJSONObject(i);
                //same as
                JSONObject j = (JSONObject) businesses.get(i);
//                System.out.println(j.get("name") + " - " + j.get("rating"));

                YelpRestaurant r = new YelpRestaurant(j);
                System.out.println(r);
            }

        }

        catch(Exception e) {
            System.out.println(e);
        }

    }
}
