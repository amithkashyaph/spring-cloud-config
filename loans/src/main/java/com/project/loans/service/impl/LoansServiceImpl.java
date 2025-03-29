package com.project.loans.service.impl;

import com.project.loans.constants.LoansConstants;
import com.project.loans.dto.LoansDto;
import com.project.loans.entity.Loans;
import com.project.loans.exception.LoanAlreadyExistsException;
import com.project.loans.exception.ResourceNotFoundException;
import com.project.loans.mapper.LoansMapper;
import com.project.loans.repository.LoansRepository;
import com.project.loans.service.LoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements LoansService {
}
