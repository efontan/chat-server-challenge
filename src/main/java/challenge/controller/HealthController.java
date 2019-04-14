package challenge.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.dao.SessionRepository;

@RestController
public class HealthController {
    
    @Autowired
    private SessionRepository sessionRepository;
    
    @PostMapping(value = "/check")
    public Map<String, String> check() {
        Integer result = this.sessionRepository.healthCheck();
        if (result != 1) {
            throw new RuntimeException("Unexpected database problem");
        }
        return Collections.singletonMap("health", "ok");
    }
    
}
