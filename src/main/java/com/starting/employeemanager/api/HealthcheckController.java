package com.codility.tasks.spring.healthcheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpStatusCodeException;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;


@RestController
class HealthcheckController {

    @GetMapping(value = "/healthcheck")

    public Map<String, String> healthcheck(@ModelAttribute(value="format") String someAttr) {
        Map<String, String> map = new HashMap();
        if(someAttr.equals("short")) {
            map.put("status", "OK");
        } else if (someAttr.equals("full")) {
            System.out.println(Instant.now().toString());
            map.put("currentTime", Instant.now().toString());
            map.put("status", "OK");
        }
        return map;
    }

    @PutMapping(value = "/healthcheck")
    public ResponseEntity healthcheckPut() {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PostMapping(value = "/healthcheck")
    public ResponseEntity healthcheckPost() {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }


    @DeleteMapping(value = "/healthcheck")
    public ResponseEntity healthcheckDelete() {
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

}
