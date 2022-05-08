package ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtis {
    public static String request(String api2) throws IOException {
        HttpURLConnection connection = null;
        int responCode=0;
        try {
            URL url = new URL(api2);
            connection = (HttpURLConnection)url.openConnection();
            responCode = connection.getResponseCode();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        if (200<=responCode&&responCode <= 299){
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String currenLine;
            while ((currenLine = bufferedReader.readLine()) != null){
                response.append(currenLine);
                String resutl = response.toString();
                return resutl;
            }
        }
        return null;
    }
}
