package com.uic.userandbank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID should be Long here

    private String accountNumber;

    private Double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Explicit foreign key column
    private User user;
}
