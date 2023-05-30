package com.we;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.we.controller.Controller;
import com.we.dao.AuditDAO;
import com.we.dao.ItemDAO;
import com.we.service.IService;
import com.we.service.Service;

@Configuration
@ComponentScan(basePackages = "com.we")
public class AppConfig {
	
	@Bean
    public File inventoryFile() {
        return new File("C:\\C353\\InventoryRecords.txt");
    }
	
	@Bean
    public Controller controller() {
        return new Controller(service(),inventoryFile());
    }

    @Bean
    public Service service() {
        return new Service(itemDAO(),auditDAO(),inventoryFile());
    }
    
    @Bean
    public ItemDAO itemDAO() {
        return new ItemDAO(auditDAO());
    }

    @Bean
    public AuditDAO auditDAO() {
        return new AuditDAO();
    }
	
}
