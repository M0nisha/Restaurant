package org.example.repository;


import org.example.model.Restaurantmodel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository  extends JpaRepository<Restaurantmodel, Integer >
{

}
