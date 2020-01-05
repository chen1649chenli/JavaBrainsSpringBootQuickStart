package com.lichen.javabrains.springquickstart.lesson;

import com.lichen.javabrains.springquickstart.course.Course;
import com.lichen.javabrains.springquickstart.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable("topicId") String topicId,
                                      @PathVariable("courseId") String courseId) {
        return lessonService.getAllLessons(topicId, courseId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson lesson, @PathVariable("courseId") String courseId) {
        setCourse(lesson, courseId);
        lessonService.addALesson(lesson);
    }

    private Lesson setCourse(Lesson lesson, String courseId) {
        Course course = courseService.getCourse(courseId);
        if (course != null) {
            lesson.setCourse(course);
        }else{
            lesson.setCourse(new Course(courseId, "", "",""));
        }
        return lesson;
    }
}
