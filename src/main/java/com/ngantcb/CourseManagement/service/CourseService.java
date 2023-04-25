package com.ngantcb.CourseManagement.service;

import com.ngantcb.CourseManagement.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAll();

    public Course save(Course course);

    public Course get(Long id);

    void delete(Long id);
}
