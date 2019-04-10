package challenge.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    
    @PostMapping(value = "/check")
    public Map<String, String> check() {
        // TODO
        //        int result = this.jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        //        if (result != 1) {
        //            throw new RuntimeException("Unexpected query result");
        //        }
        return Collections.singletonMap("health", "ok");
    }
    
}
