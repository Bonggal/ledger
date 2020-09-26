package com.prometheus.ledger.repository.account;

import com.prometheus.ledger.repository.account.entity.AccountDTO;
import com.prometheus.ledger.repository.member.entity.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountDTO, String> {
    @Query(value = "SELECT * FROM prod_account WHERE user_id = ?1", nativeQuery = true)
    List<AccountDTO> findAccountListByUserId(String userId);
}
