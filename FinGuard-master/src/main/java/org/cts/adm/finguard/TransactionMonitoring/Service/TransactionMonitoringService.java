package org.cts.adm.finguard.TransactionMonitoring.Service;

import org.cts.adm.finguard.CustomerOnboarding.Model.Customer;
import org.cts.adm.finguard.CustomerOnboarding.Service.CustomerLoginService;
import org.cts.adm.finguard.TransactionMonitoring.Model.Transaction;
import org.cts.adm.finguard.TransactionMonitoring.Repository.TransactionMonitoringRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionMonitoringService {

    public final TransactionMonitoringRepository transactionMonitoringRepository;
    public final CustomerLoginService customerLoginService;

    TransactionMonitoringService (TransactionMonitoringRepository transactionMonitoringRepository,
                                  CustomerLoginService customerLoginService){
        this.transactionMonitoringRepository = transactionMonitoringRepository;
        this.customerLoginService = customerLoginService;
    }

    public void createTransaction(Transaction transaction){
        try{
            Customer customer = customerLoginService.getCustomerById(1L);
            transaction.setCustomer(customer);
            transactionMonitoringRepository.save(transaction);
            System.out.println("Created Transaction Successfully");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean detectFraud(Transaction transaction){
//        Implement Logic
        return true;
    }

}
