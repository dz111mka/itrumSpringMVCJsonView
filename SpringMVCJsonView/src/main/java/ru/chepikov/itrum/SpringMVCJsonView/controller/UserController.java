package ru.chepikov.itrum.SpringMVCJsonView.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.chepikov.itrum.SpringMVCJsonView.entity.Order;
import ru.chepikov.itrum.SpringMVCJsonView.entity.User;
import ru.chepikov.itrum.SpringMVCJsonView.repository.OrderRepo;
import ru.chepikov.itrum.SpringMVCJsonView.repository.UserRepo;
import ru.chepikov.itrum.SpringMVCJsonView.view.Views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    OrderRepo orderRepo;


    @GetMapping
    @JsonView(Views.UserSummary.class)
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/{userId}")
    @JsonView(Views.UserSummary.class)
    public User getUserById(@PathVariable Long userId) {
        return userRepo.findById(userId).orElse(null);
    }


    @GetMapping("/users/{userId}/orders")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        List<Order> orderList = new ArrayList<>();
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            orderList.add(orderRepo.findById(userId).orElse(null));
            return orderList;
        }
        return Collections.emptyList();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        user.setId(userId);
        return userRepo.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepo.deleteById(userId);
    }


}
