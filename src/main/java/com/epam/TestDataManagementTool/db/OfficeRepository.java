package com.epam.TestDataManagementTool.db;

import com.epam.TestDataManagementTool.models.Office;
import org.springframework.data.repository.CrudRepository;

public interface OfficeRepository extends CrudRepository<Office, String> {
}
