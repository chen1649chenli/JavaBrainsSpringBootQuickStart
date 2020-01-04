package com.lichen.javabrains.springquickstart.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = Arrays.asList(
            new Topic("spring", "srping framework", "Spring framework Description"),
            new Topic("java", "core java", "Core Java Description"),
            new Topic("javascript", "Javascript", "Javascript Description")
    );

    public List<Topic> getAllTopics() {
        return topics;
    }
}
