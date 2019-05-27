package ru.hse.spb.keylogger;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Service
public class PingService {

    @RequestMapping("/ping")
    public String ping() {
        return "pong!";
    }

}