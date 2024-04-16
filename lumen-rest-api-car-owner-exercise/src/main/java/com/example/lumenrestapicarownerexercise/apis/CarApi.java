package com.example.lumenrestapicarownerexercise.apis;

import com.example.lumenrestapicarownerexercise.services.CarService;
import com.example.lumenrestapicarownerexercise.viewmodels.CarCreateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.CarUpdateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.CarViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
@Tag(name = "Car", description = "Car REST API Endpoints")
public class CarApi {

    private final CarService carService;


    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarViewModel>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("{carId}")
    public ResponseEntity<CarViewModel> getById(@PathVariable int carId){
        return ResponseEntity.ok(carService.getById(carId));
    }

    @PostMapping
    public ResponseEntity<CarViewModel> create(@RequestBody CarCreateViewModel car){
        return ResponseEntity.ok(carService.create(car));
    }

    @PutMapping("{carId}")
    public ResponseEntity<CarViewModel> update(@PathVariable int carId, @RequestBody CarUpdateViewModel car){
        return ResponseEntity.ok(carService.update(carId,car));
    }

    @DeleteMapping("{carId}")
    public ResponseEntity<?> delete(@PathVariable int carId){
        carService.deleteById(carId);
        return ResponseEntity.noContent().build();
    }
}
