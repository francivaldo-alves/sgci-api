package com.f3pro.sgci.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("imoveis")
public class ImovelController {

    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok("Ola mundo");
    }
}
