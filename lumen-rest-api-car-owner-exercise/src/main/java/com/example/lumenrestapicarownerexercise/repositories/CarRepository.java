package com.example.lumenrestapicarownerexercise.repositories;

import com.example.lumenrestapicarownerexercise.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer > {

}
