package com.lichen.javabrains.springquickstart.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return Arrays.asList(
                new Topic("spring", "srping framework", "Spring framework Description"),
                new Topic("java", "core java", "Core Java Description"),
                new Topic("javascript", "Javascript", "Javascript Description")
        );
    }
}
