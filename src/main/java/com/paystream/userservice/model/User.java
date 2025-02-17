package com.paystream.userservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column // No constraints
        private String username;

        @Column // No constraints
        private String password;

        @Column // No constraints
        private String role;

        public User(String username, String password, String role) {
                this.username = username;
                this.password = password;
                this.role = role;
        }
}
