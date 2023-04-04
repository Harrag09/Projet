package com.oussama.pfe.web;

import com.oussama.pfe.entity.Resto;
import com.oussama.pfe.repository.RestoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/RestoAbout")
@RequiredArgsConstructor
public class RestoController {

    private final RestoRepository RestoRepository;

    @GetMapping
    public ResponseEntity<List<Resto>> h2() {
        return ResponseEntity.ok(RestoRepository.findAll());
    }

    @PostConstruct
    public void init() {
        Resto ct = new Resto();
        ct.setNom("pizzaria.");
        ct.setAddress("lmey");
        ct.setEmail("pizz@gmail.com");


        RestoRepository.save(ct);
    }


}
