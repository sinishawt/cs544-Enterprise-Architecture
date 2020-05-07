package cs544.exercise17_2;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentService {
    private StudentDAO studentdao;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentdao = studentDAO;
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Student getStudent(long studentid) {
        return studentdao.load(studentid);
    }


}
