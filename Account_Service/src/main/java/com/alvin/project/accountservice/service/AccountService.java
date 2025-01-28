package com.alvin.project.accountservice.service;

import com.alvin.project.accountservice.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getAllAccounts();
    AccountDTO getAccountById(Long id);
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO updateAccount(Long id, AccountDTO accountDTO);
    void deleteAccount(Long id);
}