package com.oussama.pfe.web;

import com.oussama.pfe.entity.Contact;
import com.oussama.pfe.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {


    private final ContactRepository ContactRepository;

    @GetMapping
    public ResponseEntity<List<Contact>> h2() {
        return ResponseEntity.ok(ContactRepository.findAll());
    }

    @PostConstruct
    public void init() {
        Contact ct1 = new Contact();
        ct1.setMessage("Yes, it's up and running.");

        ContactRepository.save(ct1);
    }


}
