package com.alvin.project.loanservice.service;

import com.alvin.project.loanservice.dto.LoanDTO;
import com.alvin.project.loanservice.exception.ResourceNotFoundException;
import com.alvin.project.loanservice.model.Loan;
import com.alvin.project.loanservice.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public LoanDTO getLoanById(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        return convertToDTO(loan);
    }

    @Override
    public LoanDTO createLoan(LoanDTO loanDTO) {
        Loan loan = new Loan();
        loan.setAmount(loanDTO.getAmount());
        loan.setDescription(loanDTO.getDescription());
        loanRepository.save(loan);
        return convertToDTO(loan);
    }

    @Override
    public LoanDTO updateLoan(Long id, LoanDTO loanDTO) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        loan.setAmount(loanDTO.getAmount());
        loan.setDescription(loanDTO.getDescription());
        loanRepository.save(loan);
        return convertToDTO(loan);
    }

    @Override
    public void deleteLoan(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        loanRepository.delete(loan);
    }

    private LoanDTO convertToDTO(Loan loan) {
        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setId(loan.getId());
        loanDTO.setAmount(loan.getAmount());
        loanDTO.setDescription(loan.getDescription());
        return loanDTO;
    }
}