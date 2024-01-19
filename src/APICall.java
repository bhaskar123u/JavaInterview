import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICall {
  public static void main(String[] args) {
    try {
      demoGetRESTAPI();
      createNewUser();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void demoGetRESTAPI()
  {
    String apiUrl = "https://reqres.in/api/users/1";

    // Create an instance of HttpClient
    HttpClient httpClient = HttpClient.newHttpClient();

    // Create a GET request to the API
    HttpRequest httpRequest = HttpRequest.newBuilder()
        .uri(URI.create(apiUrl))
        .GET()
        .build();

    try {
      // Send the request and get the response
      HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

      // Print the response body
      System.out.println("Response Code: " + httpResponse.statusCode());
      System.out.println("Response Body: " + httpResponse.body());
    } catch (Exception e) {
      // Handle exceptions, if any
      e.printStackTrace();
    }
  }
  
  public static void createNewUser() {  
    User user = new User("Bhaskar", "bhaskar123u@gmail.com", "Porter");
    HttpRequest.BodyPublisher userPublisher = HttpRequest.BodyPublishers.ofString(Utils.convertObjectToJson(user));  
  
    HttpClient httpClient = HttpClient.newHttpClient();  
    HttpRequest request = HttpRequest  
            .newBuilder(URI.create("https://jsonplaceholder.typicode.com/users"))  
            .POST(userPublisher)  
            .setHeader("Content-Type", "application/json")  
            .build();  
  
    try {  
        HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());  
  
        int statusCode = response.statusCode();  
        System.out.println("HTTP status: " + statusCode);  
  
        User createdUser = Utils.convertJsonToUser(response.body());  
        System.out.println("Created new user: " + createdUser);  
  
        System.out.println("Headers:");  
        response.headers().map().forEach((header, value) -> System.out.println(header + " = " + String.join(", ", value)));  
    }  
    catch (IOException | InterruptedException e) {  
        throw new RuntimeException(e);  
    }  
  }
}

class User {
  String name;
  String email;
  String companyName;

  public User(String name, String email, String companyName) {
    this.name = name;
    this.email = email;
    this.companyName = companyName;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getCompanyName() {
    return companyName;
  }
}

class Utils {
  public static String convertObjectToJson(User user) {
    StringBuilder jsonBuilder = new StringBuilder();

    // Start JSON object
    jsonBuilder.append("{");

    // Add name
    jsonBuilder.append("\"name\":\"").append(user.getName()).append("\",");

    // Add age
    jsonBuilder.append("\"email\":").append(user.getEmail()).append(",");

    // Add email
    jsonBuilder.append("\"companyName\":\"").append(user.getCompanyName()).append("\"");

    // End JSON object
    jsonBuilder.append("}");

    return jsonBuilder.toString();
  }

  public static User convertJsonToUser(InputStream inputStream) {
    return new User(null, null, null);
  }
}