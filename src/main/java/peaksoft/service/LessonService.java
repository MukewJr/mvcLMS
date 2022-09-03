package peaksoft.service;

import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonService {

    void saveLesson(Long courseId, Lesson lesson);

    Lesson getLessonById(Long id);

    void updateLesson(Long id, Lesson lesson);

    void deleteLessonById(Long id);

    List<Lesson> getAllLessons(Long id);
}
