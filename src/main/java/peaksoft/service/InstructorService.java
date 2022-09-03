package peaksoft.service;

import peaksoft.entity.Instructor;

import java.util.List;



public interface InstructorService {

    List<Instructor> getAllInstructors(Long companyId);

    void addInstructor(Instructor instructor);

    Instructor getInstructorById(long id);

    void deleteInstructorById(Long id);

    void updateInstructor(Long id, Instructor instructor);
    void assignInstructorToCourse(Long instructorId, Long courseId);
}
