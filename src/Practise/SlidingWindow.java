package Practise;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SlidingWindow {

    /**
     * Question
     * Given an integer array nums and two integers k and t, return the length of the longest subarray where:
     *
     * The sum of the subarray is less than or equal to t
     * The subarray length is at most k
     *
     *nums = [2, 1, 5, 2, 8], k = 2, t = 7
     * Output: 2  (subarray [5, 2])
     *
     */

    public static void main(String[] args) {

    }

    public void solution(int[] arr, int k, int t) {
        //Customers(id INT, name VARCHAR, country VARCHAR)
        //Orders(id INT, customer_id INT, amount DECIMAL, date DATE)

        String i = "SELECT c FROM customers c JOIN orders o ON c.id = o.customer_id WHERE YEAR(o.date) = 2024 GROUP BY c.customer_id ORDER BY SUM(o.amount) DESC, c.name ASC LIMIT 3";
        String iCorrected = "SELECT \n" +
                "    c.id, \n" +
                "    c.name, \n" +
                "    SUM(o.amount) AS total_amount\n" +
                "FROM customers c\n" +
                "JOIN orders o ON c.id = o.customer_id\n" +
                "WHERE o.date >= '2024-01-01' AND o.date < '2025-01-01'\n" +
                "GROUP BY c.id, c.name\n" +
                "ORDER BY total_amount DESC, c.name ASC\n" +
                "LIMIT 3;\n";

        // For each country, return the number of distinct customers who placed orders in 2024, ordered by customer count descending.

        String l = "SELECT DISTINCT(c) as customerCount from customer c JOIN orders o ON o.customer_id = c.id WHERE o.date = 2024 ORDER BY customerCount DESC";


        // Products(id INT, name VARCHAR, category VARCHAR)
        //Sales(id INT, product_id INT, quantity INT)
        //     Task:
        //Return the most sold product per category (by total quantity sold).
        String j = "SELECT p, SUM(s.quantity) as total FROM Sales s JOIN products p ON p.id = s.product_id GROUP BY p.category SORT BY total DESC LIMIT 1";

        List<String> urls = new ArrayList<>();

        Set<String> validDomains = new HashSet<>();

        for (int m = 0; m < urls.size(); m++) {
            String currentUri = urls.get(m);
            try {
                URI uri = new URI(currentUri);

                String host = uri.getHost();
                if(host != null){
                    String[] split = host.split("\\.");

                    if(split.length >1){
                        validDomains.add(split[split.length -2]+"."+split[split.length-1]);
                    } else {
                        validDomains.add(split[0]);
                    }
                }
            } catch (URISyntaxException e) {
                // Handle malformed URLs gracefully, or log the error.
                System.err.println("Invalid URL: " + currentUri);
            }
        }

//        ObjectMapper objectMapper = new ObjectMapper();
//
//        URI uri = URI.create("www.jsonplaceholder.com");
//        HttpRequest httpRequest = HttpRequest.newBuilder().uri(uri).GET().header("Application-accept", "Application-json").build();
//
//        HttpResponse httpResponse = HttpResponse.BodyHandlers(H);
//
//        HttpClient httpClient = HttpClient.newBuilder().r.build()

    }
}
