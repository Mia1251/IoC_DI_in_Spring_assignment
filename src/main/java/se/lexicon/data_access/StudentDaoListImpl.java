package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.data_access.sequencer.StudentSequencer;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {

    private List<Student> students = new ArrayList<>();


    @Override
    public Student save(Student student) {
        if (student.getId() == 0) {
            student.setId(StudentSequencer.nextStudentId());
            students.add(student);
        }
        return student;
    }

    @Override
    public Student find(int id) {
        if (id == 0) throw new IllegalArgumentException("Id should not be null");
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);

    }
}
