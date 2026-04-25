package org.cts.adm.finguard.TransactionMonitoring.Repository;

import org.cts.adm.finguard.TransactionMonitoring.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMonitoringRepository extends JpaRepository<Transaction,
        Long> {

}
