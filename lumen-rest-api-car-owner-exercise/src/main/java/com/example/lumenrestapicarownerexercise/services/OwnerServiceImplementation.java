package com.example.lumenrestapicarownerexercise.services;

import com.example.lumenrestapicarownerexercise.exceptions.RecordNotFoundException;
import com.example.lumenrestapicarownerexercise.models.Owner;
import com.example.lumenrestapicarownerexercise.repositories.CarRepository;
import com.example.lumenrestapicarownerexercise.repositories.OwnerRepository;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerCreateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerUpdateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImplementation implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImplementation(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<OwnerViewModel> getAll() {
        return ownerRepository
                .findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerViewModel getById(int ownerId) {

        return toViewModel(getEntityById(ownerId));
    }

    @Override
    public OwnerViewModel create(OwnerCreateViewModel viewModel) {
        return toViewModel(ownerRepository.saveAndFlush(toEntity(viewModel)));
    }

    @Override
    public OwnerViewModel update(int ownerId, OwnerUpdateViewModel viewModel) {

        return toViewModel(ownerRepository.saveAndFlush(toUpdatedEntity(viewModel,getEntityById(ownerId))));
    }

    @Override
    public void deleteById(int ownerId) {
        ownerRepository.delete(getEntityById(ownerId));
    }

    private Owner getEntityById(int ownerId){
        return ownerRepository.findById(ownerId)
                .orElseThrow(() ->
                        new RecordNotFoundException(String.format( "Could not find the owner with id: %d",
                                ownerId)));
    }

    private OwnerViewModel toViewModel(Owner entity) {
        OwnerViewModel viewModel = new OwnerViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }

    private Owner toEntity(OwnerCreateViewModel viewModel) {
        Owner entity = new Owner();
        BeanUtils.copyProperties(viewModel, entity);
        return entity;
    }

    private Owner toUpdatedEntity(OwnerUpdateViewModel viewModel, Owner entity) {
        BeanUtils.copyProperties(viewModel, entity);
        return entity;
    }
}
