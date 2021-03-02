package se.lexicon.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ComponentScanConfig.class})

public class StudentDaoTest {
    @Autowired
    StudentDao studentDao;

    Student studentChrister = new Student(1,"Christer");
    Student studentInger = new Student(2,"Inger");
    Student studentAndreas = new Student(3,"Andreas");
    Student studentEmma = new Student(4,"Emma");
    Student studentFilip = new Student(5,"Filip");
    Student studentHenric = new Student(6,"Henric");

    @Test
    public void test_createStudent() {
        Student student = new Student(6,"Henric");
        Student expected = studentHenric;
        Student actual = studentDao.save(new Student(6,"Henric"));

        Assert.assertEquals(expected, actual);
        System.out.println("New student : " + actual.getName());
    }

    @Test
    public void test_save() {
        Student expected = new Student(1,"Henric");
        Student actual = studentDao.save(new Student("Henric"));

        Assert.assertEquals(expected, actual);
        System.out.println("Student: " + actual.getName() + " saved");
    }

    /*@Test
    public void test_findById() {


    }

    @Test
    public void test_findAll() {

    }

    @Test
    public void test_delete() {

    }*/
}