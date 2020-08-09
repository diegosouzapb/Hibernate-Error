package com.diegosouza.hibernateerror.repository;

import com.diegosouza.hibernateerror.entity.ParentEnt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository
		extends CrudRepository<ParentEnt, Integer> {
}
