package com.UseRegistryAPI.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(
        name = "uk_app_user_username",
        columnNames = "username"
))
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false , length = 20)
    private String username;
    @Column(nullable = false )
    private String password;
    @Column(nullable =false , name = "full_name" , length = 100)
    private String fullName;
    private short age;
}
