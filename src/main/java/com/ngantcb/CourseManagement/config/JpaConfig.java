package com.ngantcb.CourseManagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.ngantcb.CourseManagement.repo")
public class JpaConfig {

}
