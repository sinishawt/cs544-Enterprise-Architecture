package cs544.exercise17_2;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Transactional(propagation = Propagation.MANDATORY)
public class StudentDAO {

    private SessionFactory sf ;
    private Collection<Student> studentlist = new ArrayList<Student>();
    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }
    public Student load(long studentid) {
        Student s = (Student) sf.getCurrentSession().createQuery("Select distinct s From Student s where s.studentid = :studentid").setParameter("studentid", studentid).setMaxResults(1).uniqueResult();
        if (s == null) {
            s = new Student(studentid, "Frank", "Brown");
            Course course1 = new Course(1101, "Java", "A");
            Course course2 = new Course(1103, "Math", "B-");
            s.addCourse(course1);
            s.addCourse(course2);
            sf.getCurrentSession().persist(s);
        }
        return s;
    }
//    public StudentDAO() {
//        Student student = new Student(11334, "Frank", "Brown");
//        Course course1 = new Course(1101, "Java", "A");
//        Course course2 = new Course(1102, "Math", "B-");
//        student.addCourse(course1);
//        student.addCourse(course2);
//        sf.getCurrentSession().persist(student);
//    }
//
//    public Student load(long studentid) {
//		Student student = (Student) sf.getCurrentSession().get(Student.class,studentid);
//		return student;
//    }


}
