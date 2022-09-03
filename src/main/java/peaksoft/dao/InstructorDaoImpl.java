package peaksoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class InstructorDaoImpl implements InstructorDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Instructor> getAllInstructors() {
        List<Instructor> instructors=manager.createQuery("select i from Instructor i",Instructor.class).getResultList();
        return instructors;
    }

    @Override
    public void addInstructor(Instructor instructor) {
      manager.persist(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return manager.find(Instructor.class,id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        Instructor instructor=manager.find(Instructor.class,id);
        for (Course course: instructor.getCourses()){
            course.getInstructors();
        }
        manager.remove(instructor);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        Instructor ins=manager.find(Instructor.class,id);
        ins.setFirstName(instructor.getFirstName());
        ins.setLastName(instructor.getLastName());
        ins.setEmail(instructor.getEmail());
        ins.setPhoneNumber(instructor.getPhoneNumber());
        ins.setSpecialization(instructor.getSpecialization());
        manager.merge(ins);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        Instructor instructor = manager.find(Instructor.class, instructorId);
        Course course = manager.find(Course.class, courseId);
        instructor.addCourse(course);
        course.addInstructors(instructor);
        manager.merge(instructor);
    }
}
