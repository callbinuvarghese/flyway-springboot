package com.binu.sample.flyway.demo.service;


import com.binu.sample.flyway.demo.dao.TeacherDAO;
import com.binu.sample.flyway.demo.data.Review;
import com.binu.sample.flyway.demo.data.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@Service
public class SimpleTeacherService implements TeacherService {
    private final TeacherDAO teacherDAO;

    public SimpleTeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addReview(String teacherID, Review review) {
        Objects.requireNonNull(teacherID);
        Objects.requireNonNull(review);
        Teacher teacher = teacherDAO
                .findById(UUID.fromString(teacherID))
                .orElseThrow(() -> new EntityNotFoundException(teacherID));
        review.setDate(LocalDate.now());
        if(teacher.getReviews() == null){
            teacher.setReviews(new ArrayList<>());
        }
        teacher.getReviews().add(review);
        teacherDAO.save(teacher);
    }
}