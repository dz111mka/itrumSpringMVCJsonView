package ru.chepikov.itrum.SpringMVCJsonView.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.chepikov.itrum.SpringMVCJsonView.view.Views;

@Entity
@Table(name = "user", schema = "spring_mvc_json_view")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonView(Views.UserSummary.class)
    private String name;
    @JsonView(Views.UserSummary.class)
    private String email;

}
