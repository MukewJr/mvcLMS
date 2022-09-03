package peaksoft.dao;

import peaksoft.entity.Instructor;
import peaksoft.entity.Student;

import java.util.List;

public interface InstructorDao {
    List<Instructor> getAllInstructors();

    void addInstructor(Instructor instructor);

    Instructor getInstructorById(Long id);

    void deleteInstructorById(Long id);

    void updateInstructor(Long id, Instructor instructor);

    void assignInstructorToCourse(Long instructorId, Long courseId);

}
