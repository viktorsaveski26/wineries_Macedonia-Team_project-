package com.example.dizajn.repository;

import com.example.dizajn.model.Userd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepod  extends JpaRepository < Userd, Integer>{
    Optional<Userd> findByEmailAndPassword(String email, String password);
    Userd findByEmail(String email);
    Userd findById(Long email);
}
