package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.dao.LessonDao;
import peaksoft.entity.Lesson;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{

    private final LessonDao lessonDao;

    public LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
      lessonDao.saveLesson(courseId,lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
     lessonDao.updateLesson(id, lesson);
    }

    @Override
    public void deleteLessonById(Long id) {
      lessonDao.deleteLessonById(id);
    }

    @Override
    public List<Lesson> getAllLessons(Long id) {
        return lessonDao.getAllLessons(id);
    }
}
