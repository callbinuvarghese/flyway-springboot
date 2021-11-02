package com.binu.sample.flyway.demo.dao;

import com.binu.sample.flyway.demo.data.Course;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface CourseDAO extends CrudRepository<Course, UUID> {}
