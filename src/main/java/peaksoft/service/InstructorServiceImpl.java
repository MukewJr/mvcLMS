package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.InstructorDao;
import peaksoft.entity.Instructor;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{

    private final InstructorDao instructorDao;

    @Autowired
    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<Instructor> getAllInstructors(Long id) {
        return instructorDao.getAllInstructors(id);
    }

    @Override
    public void addInstructor(Long id,Instructor instructor) {
     instructorDao.addInstructor(id,instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
     instructorDao.deleteInstructorById(id);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
       instructorDao.updateInstructor(id, instructor);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
      instructorDao.assignInstructorToCourse(instructorId,courseId);
    }
}
