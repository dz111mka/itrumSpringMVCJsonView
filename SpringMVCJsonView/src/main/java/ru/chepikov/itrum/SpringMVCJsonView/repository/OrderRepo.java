package ru.chepikov.itrum.SpringMVCJsonView.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chepikov.itrum.SpringMVCJsonView.entity.Order;
import ru.chepikov.itrum.SpringMVCJsonView.entity.User;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
}
