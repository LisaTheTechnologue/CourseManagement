package com.ngantcb.CourseManagement.entity;

import co.elastic.clients.util.DateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Table(name = "tbl_course")
@Entity
@Data
@NoArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Course name cannot be null")
    @Column(name = "COURSE_NAME", nullable = false, length = 45)
    private String courseName;

    @Column(name = "COURSE_CODE", nullable = false, length = 45,unique=true)
    @NotNull(message = "Course code cannot be null")
    private String courseCode;

    @Column(name = "COURSE_ALIAS", nullable = false, length = 45)
    @NotNull(message = "Course alias cannot be null")
    private String courseAlias;

    @Column(name = "STATUS", columnDefinition = "TINYINT", length = 1)
    private Boolean status=true;

    @Column(name = "CREATED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdTime;
}