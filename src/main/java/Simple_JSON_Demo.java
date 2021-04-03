
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Simple_JSON_Demo {

    public static void main(String[] args) throws ParseException, IOException {

        int count = 0;
        JSONObject jsonObject = getJsonResponse("https://jsonmock.hackerrank.com/api/countries/search?name=un");

        Long total_pages = (Long) jsonObject.get("total_pages");

        for (int i = 1; i <= total_pages; i++) {
            JSONObject response = getJsonResponse("https://jsonmock.hackerrank.com/api/countries/search?name=un&page=" + i);
            count = count + calculateCount(response);
        }

        System.out.println(count);
    }

    public static int calculateCount(JSONObject data_obj) {
        int count = 0;

        JSONArray jsonArray = (JSONArray) data_obj.get("data");

        for (Object object : jsonArray) {

            JSONObject new_obj = (JSONObject) object;

            if ((Long) new_obj.get("population") >= 100090) {
                count++;
            }
        }

        return count;
    }

    public static JSONObject getJsonResponse(String URL) throws IOException, ParseException {

        StringBuilder inline = new StringBuilder();
        JSONObject data_obj;

        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.connect();

        Scanner scanner = new Scanner(url.openStream());

        // Write all the JSON data into a string using a scanner
        while (scanner.hasNext()) {
            inline.append(scanner.nextLine());
        }
        scanner.close();

        System.out.println(inline);
        JSONParser jsonParser = new JSONParser();
        data_obj = (JSONObject) jsonParser.parse(inline.toString());

        return data_obj;
    }
}