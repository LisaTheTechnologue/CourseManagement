package com.ngantcb.CourseManagement.repo;

import com.ngantcb.CourseManagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CourseRepository extends JpaRepository<Course, Serializable> {
    @Query(value = "SELECT * FROM TBL_COURSE C " +
            "WHERE C.COURSE_CODE = :courseCode " +
            "LIMIT 1", nativeQuery = true)
    Course checkIfCourseCodeExists(@Param("courseCode") String courseCode);
}
