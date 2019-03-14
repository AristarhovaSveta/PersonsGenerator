package service;

import com.google.gson.Gson;
import domain.dto.PersonsDto;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PersonsApiService {
    private final static String HOST = "https://randomuser.me/api/";

    public PersonsDto getPersons(int count) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String uri = String.format(HOST + "?results=%d", count);
        HttpGet httpGet = new HttpGet(uri);
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            String string = EntityUtils.toString(response.getEntity());
            return new Gson().fromJson(string, PersonsDto.class);
        }
    }
}
