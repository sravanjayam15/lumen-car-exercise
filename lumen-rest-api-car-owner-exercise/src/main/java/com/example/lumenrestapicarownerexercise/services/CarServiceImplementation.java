package com.example.lumenrestapicarownerexercise.services;

import com.example.lumenrestapicarownerexercise.exceptions.RecordNotFoundException;
import com.example.lumenrestapicarownerexercise.models.Car;
import com.example.lumenrestapicarownerexercise.models.Owner;
import com.example.lumenrestapicarownerexercise.repositories.CarRepository;
import com.example.lumenrestapicarownerexercise.repositories.OwnerRepository;
import com.example.lumenrestapicarownerexercise.viewmodels.CarCreateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.CarUpdateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.CarViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImplementation implements CarService {

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public CarServiceImplementation(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<CarViewModel> getAll() {
        return carRepository.findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());

    }

    @Override
    public CarViewModel getById(int carId) {

        return toViewModel(getEntityById(carId));
    }

    @Override
    public CarViewModel create(CarCreateViewModel viewModel) {
        return toViewModel(carRepository.saveAndFlush(toEntity(viewModel)));
    }

    @Override
    public CarViewModel update(int carId, CarUpdateViewModel viewModel) {

        return toViewModel(carRepository.saveAndFlush(toUpdatedEntity(viewModel, getEntityById(carId))));
    }

    @Override
    public void deleteById(int carId) {
        carRepository.delete(getEntityById(carId));
    }

    private Car getEntityById(int carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Could not find the Car with id %d", carId)));
    }

    private Owner getMasterEntityById(int ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Could not find the owner with id: %d", ownerId)));
    }

    private CarViewModel toViewModel(Car entity) {
        CarViewModel viewModel = new CarViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        viewModel.setOwner(toViewModel(entity.getOwner()));
        return viewModel;
    }

    private OwnerViewModel toViewModel(Owner entity) {
        OwnerViewModel viewModel = new OwnerViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }

    private Car toEntity(CarCreateViewModel viewModel) {
        Car entity = new Car();
        BeanUtils.copyProperties(viewModel, entity);
        entity.setOwner(getMasterEntityById(viewModel.getOwnerId()));
        return entity;
    }

    private Car toUpdatedEntity(CarUpdateViewModel viewModel, Car entity) {
        BeanUtils.copyProperties(viewModel, entity);
        return entity;
    }
}
