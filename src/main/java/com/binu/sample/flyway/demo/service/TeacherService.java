package com.binu.sample.flyway.demo.service;


import com.binu.sample.flyway.demo.data.Review;
import javax.validation.constraints.NotNull;


public interface TeacherService {
    /**
     *
     * @param teacherID
     * @param review
     * @throws javax.persistence.EntityNotFoundException
     */
    void addReview(@NotNull String teacherID, @NotNull Review review);
}