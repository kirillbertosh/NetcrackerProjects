package com.netcracker.bertosh.dao;

import com.netcracker.bertosh.entity.Course;

import java.util.List;

public interface CourseDao {

    List<Course> getCourses();

    Course getCourseById(long id);

    void saveCourse(Course student);

    void update(Course student);

    void delete(long id);
}
