package com.lichen.javabrains.springquickstart.lesson;

import com.lichen.javabrains.springquickstart.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(String topicId, String courseId) {
        return lessonRepository.findByCourseId(courseId);
    }

    public void addALesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }
}


