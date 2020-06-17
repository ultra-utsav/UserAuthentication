package com.uv.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uv.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
