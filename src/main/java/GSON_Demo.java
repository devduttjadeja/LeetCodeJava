import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class Json_Object {
    Long page;
    Long per_page;
    Long total;
    Long total_pages;
    ArrayList<Data> data;
}

class Data {
    String title;
    String url;
    String author;
    Long num_comments;
    Long story_id;
    String story_title;
    String story_url;
    String parent_id;
    Long created_at;
}

public class GSON_Demo {

    public static void main(String[] args) throws IOException {

        List<String> result = new ArrayList<>();
        String author = "epaga";

        Json_Object jsonObject = getJsonResponse("https://jsonmock.hackerrank.com/api/articles/search?author=" + author);

        long total_pages = jsonObject.total_pages;

        for (int i = 1; i <= total_pages; i++) {
            Json_Object response = getJsonResponse("https://jsonmock.hackerrank.com/api/articles/search?author=" + author + "&page=" + i);
            result.addAll(getTitles(response));
        }

        System.out.println(result);
    }

    public static Json_Object getJsonResponse(String URL) throws IOException {

        Json_Object json_object;

        try (InputStream inputStream = new URL(URL).openStream();
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            json_object = gson.fromJson(reader, Json_Object.class);
            System.out.println(json_object);
        }

        return json_object;
    }

    public static List<String> getTitles(Json_Object json_object) {

        List<String> result = new ArrayList<>();

        for (Data obj : json_object.data) {

            String title = obj.title;
            String story_title = obj.story_title;

            if (title != null) {
                result.add(title);
            } else if (title == null && story_title != null) {
                result.add(story_title);
            }
        }

        return result;
    }
}