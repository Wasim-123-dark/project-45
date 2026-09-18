package com.example.Bank.service;

import com.example.Bank.model.Account;
import com.example.Bank.model.Admin;
import com.example.Bank.repository.AccountRepository;
import com.example.Bank.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class Adminservice {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AccountRepository accountRepository;

    // Admin login verification
    public Admin login(String username, String password) {
        Optional<Admin> adminOpt = adminRepository.findById(username);
        if (adminOpt.isPresent() && adminOpt.get().getPassword().equals(password)) {
            return adminOpt.get();
        }
        return null;
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Vault metrics calculation
    public Map<String, Object> getVaultMetrics() {
        List<Account> accounts = accountRepository.findAll();
        double totalBalance = accounts.stream().mapToDouble(Account::getBalance).sum();

        Map<String, Object> response = new HashMap<>();
        response.put("totalAccounts", accounts.size());
        response.put("totalVaultBalance", totalBalance);
        return response;
    }

    // Close/delete account
    public boolean deleteAccount(Long accountNumber) {
        if (accountRepository.existsById(accountNumber)) {
            accountRepository.deleteById(accountNumber);
            return true;
        }
        return false;
    }
}