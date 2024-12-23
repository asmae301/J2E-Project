package com.uic.userandbank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "users")  // Explicit table name in lowercase
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID should be Long here

    private String name;

    @OneToMany(mappedBy = "user")
    private List<BankAccount> bankAccounts;
}
