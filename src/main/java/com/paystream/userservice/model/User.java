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
        @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private String role;

        // ✅ Correct constructor (no 'id' assignment)
        public User(String username, String password, String role) {
                this.username = username;
                this.password = password;
                this.role = role;
        }
}
