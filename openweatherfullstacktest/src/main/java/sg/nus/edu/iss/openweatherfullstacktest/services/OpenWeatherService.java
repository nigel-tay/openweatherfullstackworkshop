package sg.nus.edu.iss.openweatherfullstacktest.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class OpenWeatherService {

    private RestTemplate rTemplate = new RestTemplate();
    
    @Value("${openweather.api.key}")
    private String OW_API_KEY;

    private String OW_URL = "https://api.openweathermap.org/data/2.5/weather";
    // https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

    public String getWeather(String city) {
        String url = UriComponentsBuilder.fromUriString(OW_URL)
                                        .queryParam("q", city)
                                        .queryParam("appid", OW_API_KEY)
                                        .toUriString();
        return rTemplate.getForEntity(url, String.class).getBody();

    }
}
