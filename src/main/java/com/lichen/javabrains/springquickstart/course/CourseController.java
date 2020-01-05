package com.lichen.javabrains.springquickstart.course;

import com.lichen.javabrains.springquickstart.topic.Topic;
import com.lichen.javabrains.springquickstart.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable  String id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable("id") String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {

        course = setTopic(topicId, course);
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable("id") String id, @PathVariable("topicId") String topicId) {

        course = setTopic(topicId, course);
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable("id") String id) {
        courseService.deleteCourse(id);
    }

    private Course setTopic(String topicId, Course course){
        Topic topic = topicService.getTopic(topicId);
        if (topic != null){
            course.setTopic(topic);
        }else{
            course.setTopic(new Topic(topicId, "", ""));
        }
        return course;
    }


}
