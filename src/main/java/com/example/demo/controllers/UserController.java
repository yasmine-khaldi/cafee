package com.example.demo.controllers;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.*;
public interface UserController extends JpaRepository<User,Integer>{

}
