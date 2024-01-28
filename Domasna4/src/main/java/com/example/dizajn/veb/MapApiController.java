package com.example.dizajn.veb;

import com.example.dizajn.model.Vina;
import com.example.dizajn.repository.VinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MapApiController {

    @Autowired
    private VinaRepository vinaRepository;

    @GetMapping("/api/vina/koordinati")
    public ResponseEntity<Map<String, Float>> getKoordinati(@RequestParam String ime) {
        try {
            Vina vina = vinaRepository.findByName(ime)
                    .orElseThrow(() -> new RuntimeException("Винарија не е пронајдена"));

            Map<String, Float> koordinatiMap = new HashMap<>();
            koordinatiMap.put("X", vina.getX());
            koordinatiMap.put("Y", vina.getY());

            return ResponseEntity.ok(koordinatiMap);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}