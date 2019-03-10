package ca.laurentian.dao.impl;

import ca.laurentian.dao.StudentDao;
import ca.laurentian.domain.Student;
import ca.laurentian.util.JDBCUtil;
import ca.laurentian.util.TextUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the implementation class of StudentDao interface.
 */
public class StudentDaoImpl implements StudentDao {
    /**
     * Finds all the students in the stu table at specific page.
     *
     * @param currentPage specific page
     * @return List<Student>
     * @throws SQLException
     */
    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        // 5  0 -- 01 page -- (1-1)*5
        // 5  5 -- 02 page -- (2-1)*5
        // 5  10 -- 03 page -- (3-1)*5
        return runner.query("select * from stu limit ? offset ?", new BeanListHandler<>(Student.class), PAGE_SIZE, (currentPage - 1) * PAGE_SIZE);
    }

    /**
     * Queries all the students.
     *
     * @return List<Student>
     * @throws SQLException
     */
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from stu", new BeanListHandler<>(Student.class));
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from stu where sid = ?", new BeanHandler<>(Student.class), sid);
    }

    /**
     * Adds student.
     *
     * @param student the student need to be added
     * @throws SQLException
     */
    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("insert into stu values (null, ?, ?, ?, ?, ?, ?)",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
        );
    }

    /**
     * Deletes students.
     *
     * @param sid the id of the student
     * @throws SQLException
     */
    @Override
    public void delete(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("delete from stu where sid = ?", sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("update stu set sname = ?, gender = ?, phone = ?, birthday = ?, hobby = ?, info = ? where sid = ?",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getSid()
        );
    }

    @Override
    public List<Student> fuzzyQuery(String sname, String sgender) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

        /*Here we have to analyse:
        If you only have a name, select * from stu where sname like?
        If only gender, select * from stu where gender =?
        If both have select * from stu where sname like? And gender=?
        If neither of them is available, query all of them.*/
        String sql = "select * from stu where 1 = 1";
        List<String> paramsList = new ArrayList<>();
        if (!TextUtil.isEmpty(sname)) {
            sql = sql + " and sname like ?";
            paramsList.add("%" + sname + "%");
        }
        if (!TextUtil.isEmpty(sgender)) {
            sql = sql + " and gender = ?";
            paramsList.add(sgender);
        }

        return runner.query(sql, new BeanListHandler<>(Student.class), paramsList.toArray());
    }

    @Override
    public int findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        Long result = (Long) runner.query("select count(*) from stu", new ScalarHandler());
        return result.intValue();
    }
}
