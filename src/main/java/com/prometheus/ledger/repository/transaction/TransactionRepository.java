package com.prometheus.ledger.repository.transaction;

import com.prometheus.ledger.repository.member.entity.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bonggal.siahaan
 * @version $Id: TransactionRepository.java, v 0.1 2020‐09‐25 17.08 bonggal.siahaan Exp $$ */
public interface TransactionRepository extends JpaRepository<MemberDTO, String> {
}
