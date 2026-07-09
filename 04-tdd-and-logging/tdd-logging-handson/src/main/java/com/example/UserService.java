package com.example;

public class UserService {
    UserRepository repo;

    public UserService(UserRepository repo){
        this.repo = repo;
    }

    public String getUser(){
        return repo.getName();
    }

    public void addUser(String name){
        repo.save(name);
    }
}
