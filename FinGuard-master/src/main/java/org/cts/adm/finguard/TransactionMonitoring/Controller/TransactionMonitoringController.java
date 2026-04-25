package org.cts.adm.finguard.TransactionMonitoring.Controller;

import org.cts.adm.finguard.TransactionMonitoring.Model.Transaction;
import org.cts.adm.finguard.TransactionMonitoring.Repository.TransactionMonitoringRepository;
import org.cts.adm.finguard.TransactionMonitoring.Service.TransactionMonitoringService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/transaction")
public class TransactionMonitoringController {

    public final TransactionMonitoringService transactionMonitoringService;
    public final TransactionMonitoringRepository transactionMonitoringRepository;

    TransactionMonitoringController(  TransactionMonitoringService transactionMonitoringService,
                                      TransactionMonitoringRepository transactionMonitoringRepository){
        this.transactionMonitoringRepository = transactionMonitoringRepository;
        this.transactionMonitoringService = transactionMonitoringService;
    }

    @PostMapping("/add")
    public void createTransaction(@RequestBody Transaction transaction){
        try{
            transactionMonitoringService.createTransaction(transaction);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/detectFraud")
    public boolean detectFraud(@RequestBody Transaction transaction){
        return transactionMonitoringService.detectFraud(transaction);
    }

}
