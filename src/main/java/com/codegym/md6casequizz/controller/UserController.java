package com.codegym.md6casequizz.controller;

import com.codegym.md6casequizz.dto.response.ResponMessage;
import com.codegym.md6casequizz.model.Result;
import com.codegym.md6casequizz.model.Test;
import com.codegym.md6casequizz.model.User;
import com.codegym.md6casequizz.service.result.IResultService;
import com.codegym.md6casequizz.service.test.ITestService;
import com.codegym.md6casequizz.service.user.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("users")
public class UserController {



    @Autowired
    UserServiceImpl userService;

    @Autowired
    private ITestService testService;

    @Autowired
    IResultService resultService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        Optional<User> user=userService.findById(id);
        if (!user.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            userService.deleteById(user.get().getId());


        return new ResponseEntity<>(new ResponMessage("delete success"),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<User>> showListUser(){
        return new ResponseEntity<>(userService.showList(),HttpStatus.OK);
    }

    @GetMapping("/{id}/tests")
    public ResponseEntity<Iterable<Test>> findTestByUser(@PathVariable Optional<String> id) {
        Optional<User> userOptional = userService.findById(Long.valueOf(id.get()));
        Iterable<Test> tests = testService.findAllByUser(userOptional.get());
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @GetMapping("/{id}/results")
    public ResponseEntity<Iterable<Result>> findResultByUser(@PathVariable Optional<String> id) {
        Optional<User> userOptional = userService.findById(Long.valueOf(id.get()));
        Iterable<Result> results = resultService.findAllByUser(userOptional.get());
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
    @GetMapping("findbyid/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user=userService.findById(id);
        if (!user.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }
}

