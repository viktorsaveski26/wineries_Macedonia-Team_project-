package com.example.dizajn.repository;


import com.example.dizajn.model.Userd;
import com.example.dizajn.model.Vina;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VinaRepository  extends JpaRepository<Vina, Integer> {
    Optional<Vina> findByName (String name);

    Vina findById(Long id);

}
