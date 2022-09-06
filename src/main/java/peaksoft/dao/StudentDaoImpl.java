package peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableTransactionManagement

public class StudentDaoImpl implements StudentDao{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void saveStudent(Long id, Student student) {
        Company company=manager.find(Company.class,id);
        company.addStudent(student);
        student.setCompany(company);
        manager.persist(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
      Student st=manager.find(Student.class,id);
      st.setFirstName(student.getFirstName());
      st.setLastName(student.getLastName());
      st.setPhoneNumber(student.getPhoneNumber());
      st.setEmail(student.getEmail());
      st.setStudyFormat(student.getStudyFormat());
      manager.merge(st);
    }

    @Override
    public List<Student> getAllStudents(Long id) {
        List<Student> studentList=manager.createQuery("select s from Student s where s.company.companyId=:id",
                Student.class).setParameter("id",id).getResultList();
        return studentList;
    }

    @Override
    public Student getStudentById(Long id) {
        return manager.find(Student.class,id);
    }

    @Override
    public void deleteStudentById(Long id) {
        Student student=manager.find(Student.class,id);
        student.setCourse(null);
        manager.remove(student);
    }

    @Override
    public void assignStudentToCourse(Long studentId, Long courseId) {
        Student student = manager.find(Student.class, studentId);
        Course course = manager.find(Course.class, courseId);
        student.setCourse(course);
        course.addStudents(student);
        manager.merge(student);
    }

    @Override
    public List<Student> countOfStudents(Long id) {
        List<Student> students =  manager.createQuery("SELECT COUNT(c.students.size) FROM Company c",Student.class).getResultList();
        return students;
    }
}
