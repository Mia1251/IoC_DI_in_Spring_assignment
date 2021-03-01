package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    Set<Student> students = new HashSet<>();
    private UserInputService scannerService;
    private StudentDao studentDao;

    @Autowired
    public void setScannerService(UserInputService scannerService) {
        this.scannerService = scannerService;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Enter your name: ");
        String studentName = scannerService.getString();
        Student addStudent = new Student();
        addStudent.setName(studentName);
        return save(addStudent);
    }

    @Override
    public Student save(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student name is null");
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("No student found with id: ");
        }
        return find(id);
    }

    @Override
    public Student remove(int id) {
        Student removeStudent = find(id);
        if (removeStudent == null)
            throw new IllegalArgumentException("Student not found with id: " + id);
        studentDao.delete(id);

        return removeStudent;
    }

    @Override
    public List<Student> findAll() {
        System.out.println("Enlisted students: ");
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student.getId() == 0)
            throw new IllegalArgumentException("Student id can't be null");
        Student original = find(student.getId());

        System.out.println("Edit students name: ");
        String editName = scannerService.getString();
        original.setName(editName);

        return original;
    }
}