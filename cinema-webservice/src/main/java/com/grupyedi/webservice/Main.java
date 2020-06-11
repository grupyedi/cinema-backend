package com.grupyedi.webservice;

import java.util.List;

import com.grupyedi.webservice.dao.TicketDao;
import com.grupyedi.webservice.entity.Student;
import com.grupyedi.webservice.dao.StudentDao;
import com.grupyedi.webservice.entity.Ticket;
import com.grupyedi.webservice.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
//        StudentDao studentDao = new StudentDao();
//        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
//        studentDao.saveStudent(student);
//        List < Student > students = studentDao.getStudents();
//        students.forEach(s -> System.out.println(s.getFirstName()));

//        TicketDao ticketDao = new TicketDao();
//        Ticket ticket = new Ticket(30, "Sevgililer Gunu Bileti", 50);
//        ticketDao.saveTicket(ticket);
//        List <Ticket> tickets = ticketDao.getTicket();
//        tickets.forEach(t -> System.out.println(t.description));
        HibernateUtil.getSessionFactory();
    }
}
