package com.example.dizajn.service;

import com.example.dizajn.model.Vina;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface VinaService {

    List<Vina> listall();
//    void addocena (Integer ocena, Long vinarija);
    List<Vina> sort();

    void addonena(Long idkornisnik, Long idvinarija);
}
