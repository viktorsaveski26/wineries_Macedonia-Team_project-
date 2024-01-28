package com.example.dizajn.service.impl;
import com.example.dizajn.model.Vina;
import com.example.dizajn.repository.VinaRepository;
import com.example.dizajn.service.VinaService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VinaServiceImpl implements VinaService {

    public final VinaRepository vinaRepository;

    public VinaServiceImpl(VinaRepository vinaRepository) {
        this.vinaRepository = vinaRepository;
    }

    @Override
    public List<Vina> listall() {
        return  vinaRepository.findAll();
    }

    @Override
    public List<Vina> sort() {
       List<Vina> vinaList = vinaRepository.findAll();
       List<Vina> filteredAndSortedVinaList = vinaList.stream()
               .filter(v -> v.getRating() != null)
               .sorted(Comparator.comparingDouble(Vina::getRating).reversed()).limit(5)
               .collect(Collectors.toList());
       return filteredAndSortedVinaList;
    }

    @Override
    public void addonena(Long idkornisnik, Long idvinarija) {

    }

}
