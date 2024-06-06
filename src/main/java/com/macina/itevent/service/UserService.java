package com.macina.itevent.service;

import com.macina.itevent.model.User;
import com.macina.itevent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService implements CommandLineRunner, IUserService {

    @Autowired
    UserRepository userRepository;

    public Page<User> getAllUsers(Integer pageNumber, Integer pageSize){
        PageRequest pr = PageRequest.of(pageNumber,pageSize);
        return userRepository.findAll(pr);
    }

    public User addOneUser(User userToAdd){
        return userRepository.save(userToAdd);
    }


    // !!!!!!! use it only during development
    public void addRandomUsers(){
        Random r = new Random();

        int i=0;
        while(i<=50){
            int n1 = r.nextInt(0,12);
            int n2 = r.nextInt(0,12);
            String[] possibleNames = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace",
                    "Hank", "Ivy", "Jack", "Kara", "Liam"};
            String[] possibleSurnames = {
                    "Smith", "Johnson", "Williams", "Jones", "Brown",
                    "Davis", "Miller", "Wilson", "Moore", "Taylor",
                    "Anderson", "Thomas"
            };
            String name = possibleNames[n1];
            String lastname = possibleSurnames[n2];
            String email = String.format("%s.%s@gmail.com",name,lastname);
            String role = n1 <= 5 ?
                    "Speaker" : n1 <= 10 ? "Presentatore" : "Spettatore";
            User u = new User(
                    name,lastname,email,role,null,null,null,n1 * 2
            );
            userRepository.save(u);
            i++;
        }

    }

    @Override
    public void run(String... args) throws Exception {
        addRandomUsers();
    }


}
