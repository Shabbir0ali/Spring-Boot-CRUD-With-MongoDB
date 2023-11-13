package com.shabbir.api.user.repositry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shabbir.api.user.model.User;

public interface UserRepositry extends MongoRepository<User, String>{}