package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Yandex {

    static String site = "https://yandex.ru";
    public static void main(String[] args) throws IOException {
        URL url = new URL(site);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        int responseCode = urlConnection.getResponseCode();
        System.out.println(responseCode);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String input;
        while ((input = bufferedReader.readLine()) != null) {

            stringBuilder.append(input).append("/n");
        }
        System.out.println(stringBuilder);
        }

}






