package com.alvin.project.accountservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvin.project.accountservice.dto.AccountDTO;
import com.alvin.project.accountservice.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

	private AccountService accountService;

	@GetMapping
	public List<AccountDTO> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
		return ResponseEntity.ok(accountService.getAccountById(id));
	}

	@PostMapping
	public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
		return ResponseEntity.ok(accountService.createAccount(accountDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AccountDTO> updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO) {
		return ResponseEntity.ok(accountService.updateAccount(id, accountDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
		accountService.deleteAccount(id);
		return ResponseEntity.noContent().build();
	}
}