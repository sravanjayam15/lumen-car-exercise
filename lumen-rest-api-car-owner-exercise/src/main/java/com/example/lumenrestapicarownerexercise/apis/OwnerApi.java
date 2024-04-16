package com.example.lumenrestapicarownerexercise.apis;

import com.example.lumenrestapicarownerexercise.services.OwnerService;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerCreateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerUpdateViewModel;
import com.example.lumenrestapicarownerexercise.viewmodels.OwnerViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/owners")
@Tag(name = "Owner", description = "Owner REST API Endpoints")
public class OwnerApi {


    private final OwnerService ownerService;

    public OwnerApi(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerViewModel>> getAll(){
        return ResponseEntity.ok(ownerService.getAll());
    }

    @GetMapping("{ownerId}")
    public ResponseEntity<OwnerViewModel> getById(@PathVariable int ownerId){
        return ResponseEntity.ok(ownerService.getById(ownerId));
    }

    @PostMapping
    public ResponseEntity<OwnerViewModel>  create(@RequestBody OwnerCreateViewModel owner){
        return ResponseEntity.ok(ownerService.create(owner));
    }

    @PutMapping("{ownerId}")
    public ResponseEntity<OwnerViewModel> update(@PathVariable int ownerId,@RequestBody OwnerUpdateViewModel owner){
        return ResponseEntity.ok(ownerService.update(ownerId,owner));
    }

    @DeleteMapping("{ownerId}")
    public ResponseEntity<?> deleteById(@PathVariable int ownerId) {
        ownerService.deleteById(ownerId);
        return ResponseEntity.noContent().build();
    }
}


