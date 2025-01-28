package com.alvin.project.loanservice.service;

import com.alvin.project.loanservice.dto.LoanDTO;

import java.util.List;

public interface LoanService {
    List<LoanDTO> getAllLoans();
    LoanDTO getLoanById(Long id);
    LoanDTO createLoan(LoanDTO loanDTO);
    LoanDTO updateLoan(Long id, LoanDTO loanDTO);
    void deleteLoan(Long id);
}