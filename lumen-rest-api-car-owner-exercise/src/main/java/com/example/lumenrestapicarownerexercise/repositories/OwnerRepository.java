package com.example.lumenrestapicarownerexercise.repositories;

import com.example.lumenrestapicarownerexercise.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
