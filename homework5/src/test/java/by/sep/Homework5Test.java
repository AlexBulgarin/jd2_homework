package by.sep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.AbstractMap;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class Homework5Test {
    @Autowired
    Student student;
    @Autowired
    Master master;
    @Autowired(required = false)
    Doctor doctor;

    @Test
    public void testTask2() {
        assertNotNull(student);
        assertEquals("Peter", student.getFirstName());
        assertEquals("Parker", student.getLastName());
        assertEquals(3, student.getMarks().size());
        assertTrue(student.getMarks().entrySet().contains(new AbstractMap.SimpleEntry<>("Math", "A")));
        assertTrue(student.getMarks().entrySet().contains(new AbstractMap.SimpleEntry<>("Physics", "A")));
        assertTrue(student.getMarks().entrySet().contains(new AbstractMap.SimpleEntry<>("Biology", "B")));
    }

    @Test
    public void testTask8() {
        StudentInfo info = (StudentInfo) student.getStudentInfo();
        assertEquals("S00123", info.getStudentCardNumber());
        assertEquals("R00435", info.getRecordBookNumber());
        assertEquals("L00342", info.getLibraryCardNumber());
    }

    @Test
    public void testTask9() {
        assertNotNull(master);
        assertEquals("Michael", master.getFirstName());
        assertEquals("Morbius", master.getLastName());
        StudentInfo2 info2 = (StudentInfo2) master.getStudentInfo();
        assertEquals("bioengineering", info2.getFaculty());
        assertEquals("rad-3", info2.getGroup());
    }

    @Test
    public void testTask10() {
        assertNull(doctor);
    }
}