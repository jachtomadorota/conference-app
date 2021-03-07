package com.dorotajachtoma.conferenceapp.repository;


import com.dorotajachtoma.conferenceapp.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}
