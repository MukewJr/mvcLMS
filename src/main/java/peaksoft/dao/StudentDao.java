package peaksoft.dao;

import peaksoft.entity.Company;
import peaksoft.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> countOfStudents(Long id);

    void saveStudent(Long id, Student student);

    void updateStudent(Long id, Student student);

    List<Student> getAllStudents(Long id);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);

    void assignStudentToCourse(Long studentId, Long courseId);


}
