package com.netcracker.bertosh.dao;

import com.netcracker.bertosh.connection.ConnectionDB;
import com.netcracker.bertosh.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultCourseDao implements CourseDao {

    private final String GET_COURSES = "SELECT id_course, name, surname, age FROM course";

    private final String GET_COURSE_ID = "SELECT id_course, name, surname, age FROM course WHERE id_course=?";

    private final String INSERT_COURSE = "INSERT INTO course (id_course,name,trainer_name,trainer_surname,hours_count) VALUES (?,?,?,?,?)";

    private final String UPDATE_COURSE = " UPDATE course SET name =?, trainer_name = ?, trainer_surname = ?, hours_count=? WHERE id_student=?";

    private final String DELETE_COURSE = "DELETE FROM course WHERE id_course=?";

    private ConnectionDB connectionDB = ConnectionDB.getInstance();

    private DefaultCourseDao() {

    }

    @Override
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_COURSES);
            while (resultSet.next()) {
                Course course = new Course(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            checkExceptions(connection, statement, resultSet);
        }
        return courses;
    }

    @Override
    public Course getCourseById(long id) {
        Course course = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(GET_COURSE_ID);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                course = new Course(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            checkExceptions(connection, preparedStatement, resultSet);
        }
        return course;
    }

    @Override
    public void saveCourse(Course course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_COURSE);
            preparedStatement.setLong(1, course.getId());
            preparedStatement.setString(2, course.getName());
            preparedStatement.setString(3, course.getTrainerName());
            preparedStatement.setString(4, course.getTrainerSurname());
            preparedStatement.setInt(5, course.getHoursCount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            checkExceptions(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void update(Course course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_COURSE);
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getTrainerName());
            preparedStatement.setString(3, course.getTrainerSurname());
            preparedStatement.setLong(4, course.getHoursCount());
            preparedStatement.setLong(5, course.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            checkExceptions(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void delete(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_COURSE);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            checkExceptions(connection, preparedStatement, resultSet);
        }
    }

    private void checkExceptions(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The inner class for implementation singleton.
     */
    private static class Holder {
        private final static DefaultCourseDao INSTANCE = new DefaultCourseDao();
    }

    /**
     * The method gives DefaultStudentDao singleton instance.
     */
    public static DefaultCourseDao getInstance() {
        return Holder.INSTANCE;
    }
}
