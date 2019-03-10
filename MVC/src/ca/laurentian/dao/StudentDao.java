package ca.laurentian.dao;

import ca.laurentian.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * This is the DAO for stu table.
 */
public interface StudentDao {
    // public static final int PAGE_SIZE = 5;
    // all the variables defined in the interface is constant!
    // define the number of items shown in one page
    int PAGE_SIZE = 5;

    /**
     * Finds all the students in the stu table at specific page.
     *
     * @param currentPage specific page
     * @return List<Student>
     * @throws SQLException
     */
    List<Student> findStudentByPage(int currentPage) throws SQLException;

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
     * Updates students' information.
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

    /**
     * Queries the total number of student records in stu.
     *
     * @return total number of items
     * @throws SQLException
     */
    int findCount() throws SQLException;
}
