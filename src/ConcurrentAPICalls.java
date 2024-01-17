// Sample API response
/*
{
  "data": {
    "id": 1,
    "email": "george.bluth@reqres.in",
    "first_name": "George",
    "last_name": "Bluth",
    "avatar": "https://reqres.in/img/faces/1-image.jpg"
  },
  "support": {
    "url": "https://reqres.in/#support-heading",
    "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
  }
}
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ConcurrentAPICalls {

  public static void main(String[] args) {
    // URLs of the three APIs
    String apiUrl1 = "https://reqres.in/api/users/1";
    String apiUrl2 = "https://reqres.in/api/users/2";
    String apiUrl3 = "https://reqres.in/api/users/3";

    // Create a list of CompletableFuture objects for each API call
    CompletableFuture<String> api1Future = callApi(apiUrl1);
    CompletableFuture<String> api2Future = callApi(apiUrl2);
    CompletableFuture<String> api3Future = callApi(apiUrl3);

    // Combine the results when all CompletableFuture objects are completed
    CompletableFuture<List<String>> combinedFuture = CompletableFuture.allOf(api1Future, api2Future, api3Future)
        .thenApply(v -> List.of(api1Future.join(), api2Future.join(), api3Future.join()));

    // Process the combined response
    combinedFuture.thenAccept(responseList -> {
      // Add first names from all responses
      String combinedResponse = responseList.stream().collect(Collectors.joining(", "));
      System.out.println("Combined Response: " + combinedResponse);
    });

    // Wait for the combinedFuture to complete
    combinedFuture.join();
  }

  private static CompletableFuture<String> callApi(String apiUrl) {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest.newBuilder()
        .uri(URI.create(apiUrl))
        .build();

    return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenApply(responseBody -> {
          
          return extractFirstNameFromJson(responseBody);
        });
  }

  private static String extractFirstNameFromJson(String responseBody) {

    int indexOfFirstName = responseBody.indexOf("\"first_name\":\"");
    int indexOfLastName = responseBody.indexOf(",\"last_name\"");
    return responseBody.substring(indexOfFirstName+14, indexOfLastName-1);    
  }
}
