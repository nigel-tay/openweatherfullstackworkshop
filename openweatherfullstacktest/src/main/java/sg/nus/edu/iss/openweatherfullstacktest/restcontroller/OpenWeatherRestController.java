package sg.nus.edu.iss.openweatherfullstacktest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.edu.iss.openweatherfullstacktest.services.OpenWeatherService;

@RestController
@RequestMapping("/api")
public class OpenWeatherRestController {

    @Autowired
    OpenWeatherService owService;
    
    @GetMapping("/getweather")
    @CrossOrigin()
    public ResponseEntity<String> getWeatherByCity(@RequestParam String city) {
        return ResponseEntity.ok(owService.getWeather(city));
    }
    }
