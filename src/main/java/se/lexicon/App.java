package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.List;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        System.out.println("Create student: ");
        System.out.println(studentManagement.create());

        System.out.println("-----------------------------------------------------");

        System.out.println("Save student: ");

        Student student1 = studentManagement.save(new Student("Christer"));
        Student student2 = studentManagement.save(new Student("Inger"));
        Student student3 = studentManagement.save(new Student("Andreas"));
        Student student4 = studentManagement.save(new Student("Emma"));
        Student student5 = studentManagement.save(new Student("Filip"));

        System.out.println("-----------------------------------------------------");

        System.out.println("Find all students: ");
        List<Student> findAll = studentManagement.findAll();
        findAll.forEach(System.out::println);

        System.out.println("-----------------------------------------------------");

        System.out.println("Find student with id 1: ");
        System.out.println(studentManagement.find(1));
        System.out.println("Find student with id 4: ");
        System.out.println(studentManagement.find(4));

        System.out.println("-----------------------------------------------------");

        System.out.println("Remove student with id (id 2)");
        studentDao.delete(2);

        System.out.println("-----------------------------------------------------");

        System.out.println("List of all enlisted students after removing student: ");
        // to see that the removed student is missing in the list
        List<Student> findAll1 = studentManagement.findAll();
        findAll1.forEach(System.out::println);

        Student editStudent = studentManagement.edit(student4);
        System.out.println("-----------------------------------------------------");

        System.out.println("List of all enlisted students after editing: ");
        List<Student> findAll2 = studentManagement.findAll();
        findAll2.forEach(System.out::println);

    }

}
