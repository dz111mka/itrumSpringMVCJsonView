package ru.chepikov.itrum.SpringMVCJsonView.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chepikov.itrum.SpringMVCJsonView.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

}
