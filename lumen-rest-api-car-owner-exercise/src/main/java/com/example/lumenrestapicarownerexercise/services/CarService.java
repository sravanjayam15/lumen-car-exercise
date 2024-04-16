package com.example.lumenrestapicarownerexercise.services;

import com.example.lumenrestapicarownerexercise.viewmodels.CarCreateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.CarUpdateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.CarViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<CarViewModel> getAll(); // //GetAll

    CarViewModel getById(int carId);     //GetById


     CarViewModel create(CarCreateViewModel viewModel);    //create

     CarViewModel update(int carId, CarUpdateViewModel viewModel); //    //update


     void deleteById(int carId);  //DeleteById

}
