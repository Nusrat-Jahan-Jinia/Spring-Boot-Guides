package com.example.demo.service;


import com.example.demo.entity.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;


@Service
public class GitHubLookupService {

    private static Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }


    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException{
        logger.info("looking up "+ user);

        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);

        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }
}