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
    public List<Instructor> getAllInstructors(Long companyId) {
        return instructorDao.getAllInstructors();
    }

    @Override
    public void addInstructor(Instructor instructor) {
     instructorDao.addInstructor(instructor);
    }

    @Override
    public Instructor getInstructorById(long id) {
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
