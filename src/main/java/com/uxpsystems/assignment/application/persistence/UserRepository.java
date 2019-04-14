package com.uxpsystems.assignment.application.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignment.application.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	
}
