package com.lichen.javabrains.springquickstart.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "srping framework", "Spring framework Description"),
            new Topic("java", "core java", "Core Java Description"),
            new Topic("javascript", "Javascript", "Javascript Description")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic (String id) {
       return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic){
        topics.removeIf(t -> t.getId().equals(id));
        topics.add(topic);
        return;
    }

    public void deleteTopic(String id){
        topics.removeIf(t -> t.getId().equals(id));
        return;
    }
}
