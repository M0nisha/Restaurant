package org.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.model.Restaurantmodel;
import org.example.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Restaurantservice {

    @Autowired
    public RestaurantRepository repository;

    //Get
    public  List<Restaurantmodel> getrestaurantmodels()
    {
        List<Restaurantmodel>  modellist = new ArrayList<>();
        return modellist;
    }
    //post
    public Restaurantmodel save(Restaurantmodel model)

    {
        return repository.save(model);
    }
    //put
    public Restaurantmodel save(Integer id , Restaurantmodel  model )
    {
        Optional<Restaurantmodel> findById = repository.findById(id);
        return repository.save(model);
    }
    //delete
    public void delete(Integer id) {

        repository.deleteById(id);
    }



}
