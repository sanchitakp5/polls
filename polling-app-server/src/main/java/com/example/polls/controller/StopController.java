package com.example.polls.controller;

import com.example.polls.PollsApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StopController {

    @PostMapping("/stop")
    public void restart() {
        PollsApplication.stop();
    }
}