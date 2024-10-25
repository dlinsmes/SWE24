import org.json.*;
import java.util.ArrayList;
public class YelpRestaurant {

    String name;
    double rating;
    String address; //house number and street name
    String city;
    int price; //if it has one, otherwise set as -1
    ArrayList<String> keywords; //add both aliases and keywords from all categories

    public YelpRestaurant(JSONObject o) {
        //parse all data from the param object

        //JSONObject loc = o.getJSONObject("location");
        JSONObject loc = (JSONObject) o.get("location");
        address = loc.getString("address1");
    }

    public String toString() {
        return "";
    }
}
