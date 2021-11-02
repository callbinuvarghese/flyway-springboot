package com.binu.sample.flyway.demo.dao;


import com.binu.sample.flyway.demo.data.Teacher;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface TeacherDAO extends CrudRepository<Teacher, UUID> {}
