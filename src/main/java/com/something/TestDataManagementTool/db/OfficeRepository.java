package com.something.TestDataManagementTool.db;

import com.something.TestDataManagementTool.models.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, String> {
}
