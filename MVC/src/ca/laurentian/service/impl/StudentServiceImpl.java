package ca.laurentian.service.impl;

import ca.laurentian.dao.StudentDao;
import ca.laurentian.dao.impl.StudentDaoImpl;
import ca.laurentian.domain.PageBean;
import ca.laurentian.domain.Student;
import ca.laurentian.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * This is the implementation class of StudentService interface.
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public PageBean<Student> findStudentByPage(int currentPage) throws SQLException {
        PageBean<Student> pageBean = new PageBean<>();
        int pageSize = StudentDao.PAGE_SIZE;

        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.findStudentByPage(currentPage);
        pageBean.setList(students);

        int count = studentDao.findCount();
        pageBean.setTotalSize(count);
        pageBean.setTotalPage(count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1);
        return pageBean;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.findAll();
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.findStudentById(sid);
    }

    @Override
    public void insert(Student student) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.insert(student);
    }

    @Override
    public void delete(int sid) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.delete(sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.update(student);
    }

    @Override
    public List<Student> fuzzyQuery(String sname, String sgender) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.fuzzyQuery(sname, sgender);
    }
}
