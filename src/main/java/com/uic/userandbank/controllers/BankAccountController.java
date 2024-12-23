package com.uic.userandbank.controllers;

import com.uic.userandbank.entities.BankAccount;
import com.uic.userandbank.entities.User;
import com.uic.userandbank.repositories.BankAccountRepository;
import com.uic.userandbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public String listBankAccounts(Model model) {
        model.addAttribute("accounts", bankAccountRepository.findAll());
        return "accounts";
    }

    @GetMapping("/new")
    @PreAuthorize("isAuthenticated()")
    public String addNewBankAccountForm(Model model) {
        model.addAttribute("bankAccount", new BankAccount());
        model.addAttribute("users", userRepository.findAll());
        return "bank-account-form";
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public String saveBankAccount(@ModelAttribute BankAccount bankAccount, @RequestParam("userId") Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            bankAccount.setUser(user);
            bankAccountRepository.save(bankAccount);
        }
        return "redirect:/accounts";
    }
}
