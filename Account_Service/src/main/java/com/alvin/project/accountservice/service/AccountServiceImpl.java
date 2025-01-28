package com.alvin.project.accountservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.alvin.project.accountservice.dto.AccountDTO;
import com.alvin.project.accountservice.exception.ResourceNotFoundException;
import com.alvin.project.accountservice.model.Account;
import com.alvin.project.accountservice.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	@Override
	public List<AccountDTO> getAllAccounts() {
		return accountRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public AccountDTO getAccountById(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found"));
		return convertToDTO(account);
	}

	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		Account account = new Account();
		account.setName(accountDTO.getName());
		account.setBalance(accountDTO.getBalance());
		accountRepository.save(account);
		return convertToDTO(account);
	}

	@Override
	public AccountDTO updateAccount(Long id, AccountDTO accountDTO) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found"));
		account.setName(accountDTO.getName());
		account.setBalance(accountDTO.getBalance());
		accountRepository.save(account);
		return convertToDTO(account);
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found"));
		accountRepository.delete(account);
	}

	private AccountDTO convertToDTO(Account account) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(account.getId());
		accountDTO.setName(account.getName());
		accountDTO.setBalance(account.getBalance());
		return accountDTO;
	}
}