package org.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.example.model.Restaurantmodel;

import org.example.service.Restaurantservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Restaurantcontroller {


    @Autowired
    public Restaurantservice restaurantservice ;



    @GetMapping("/get")
    public List<Restaurantmodel>  getrestaurantmodels()
    {
        return restaurantservice.getrestaurantmodels();
    }


    @PostMapping("/create")
    public Restaurantmodel createrestaurantmodel( @Valid @RequestBody Restaurantmodel  model )
    {
        return restaurantservice.save(model);
    }

    @PutMapping ("/update/{id}")
    public Restaurantmodel  updaterestaurantmodel( @PathVariable("id") Integer id , @Valid @RequestBody Restaurantmodel  model)
    {
        model.setId(id);
        return restaurantservice.save(model);

    }

    @DeleteMapping("/delete/{id}")
    public void deleterestaurantmodel(@PathVariable("id") Integer id)
    {
        restaurantservice.delete(id);
    }


}
