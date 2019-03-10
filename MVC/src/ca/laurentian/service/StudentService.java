package ca.laurentian.service;

import ca.laurentian.domain.PageBean;
import ca.laurentian.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * A XxxDao corresponds to a XxxService.
 */
public interface StudentService {
    /**
     * Finds all the students in the stu table in current page and other necessary information about table.
     *
     * @param currentPage current page
     * @return PageBean<Student>
     * @throws SQLException
     */
    PageBean<Student> findStudentByPage(int currentPage) throws SQLException;

    /**
     * Finds all the students in the stu table.
     *
     * @return List<Student>
     */
    List<Student> findAll() throws SQLException;

    /**
     * Finds a students in the stu table by sid.
     *
     * @param sid the id of the student
     * @return Student
     * @throws SQLException
     */
    Student findStudentById(int sid) throws SQLException;

    /**
     * Adds a student to stu table.
     *
     * @param student the student need to be added
     * @throws SQLException
     */
    void insert(Student student) throws SQLException;

    /**
     * Deletes the student according to SID
     *
     * @param sid the id of the student
     * @throws SQLException
     */
    void delete(int sid) throws SQLException;

    /**
     * Update students' information.
     *
     * @param student updated student information
     * @throws SQLException
     */
    void update(Student student) throws SQLException;

    /**
     * Fuzzy query by student's name or gender or name and gender.
     *
     * @param sname   student's name
     * @param sgender student's gender
     * @return List<Student>
     * @throws SQLException
     */
    List<Student> fuzzyQuery(String sname, String sgender) throws SQLException;
}
