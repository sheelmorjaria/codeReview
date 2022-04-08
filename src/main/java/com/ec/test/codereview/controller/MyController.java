package com.ec.test.codereview.controller;


import com.ec.test.codereview.Prime;
import com.ec.test.codereview.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prime")
public class MyController {

    @Autowired
    private Repo myRepo;

    @GetMapping("{id}")
    public String doTheWork(@PathVariable("id") int id) {


        if (myRepo.findById(id).isPresent()) {
            return myRepo.findById(id) + " is Prime";
        }

        for (var i = 2; i < id; i++) {
            if (id % i == 0) {
                return id + "is not prime";
            }
        }

        Prime p = new Prime();
        p.setValue(id);
        myRepo.save(p);

        return id + " is Prime";

    }
}
