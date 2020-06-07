package com.grupyedi.webservice;

import java.util.List;

import com.grupyedi.webservice.entity.Student;
import com.grupyedi.webservice.dao.StudentDao;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        studentDao.saveStudent(student);
        List < Student > students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s.getFirstName()));
    }
}
