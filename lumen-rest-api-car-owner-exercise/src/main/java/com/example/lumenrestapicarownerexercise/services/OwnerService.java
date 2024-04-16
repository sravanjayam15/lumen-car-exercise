package com.example.lumenrestapicarownerexercise.services;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerCreateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerUpdateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerViewModel;


import java.util.List;

public interface OwnerService
{

    List<OwnerViewModel> getAll();
    OwnerViewModel getById(int ownerId);
    OwnerViewModel create(OwnerCreateViewModel viewModel);
    OwnerViewModel update(int ownerId, OwnerUpdateViewModel viewModel);
    void deleteById(int ownerId);
}
