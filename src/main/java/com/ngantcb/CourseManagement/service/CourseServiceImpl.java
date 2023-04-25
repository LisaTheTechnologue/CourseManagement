package com.ngantcb.CourseManagement.service;
import com.ngantcb.CourseManagement.entity.Course;
import com.ngantcb.CourseManagement.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repo;

    @Override
    public List<Course> getAll() {
        return repo.findAll();
    }

    @Override
    public Course get(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Course save(Course course) {
        Course itemDb = repo.checkIfCourseCodeExists(course.getCourseCode());
        if (itemDb != null) return null;
        return repo.save(course);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}