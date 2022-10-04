package com.epam.TestDataManagementTool.db;

import com.epam.TestDataManagementTool.models.Payment;
import com.epam.TestDataManagementTool.models.PaymentId;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, PaymentId> {
}
