package com.something.TestDataManagementTool.db;

import com.something.TestDataManagementTool.models.entities.Payment;
import com.something.TestDataManagementTool.models.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {
}
