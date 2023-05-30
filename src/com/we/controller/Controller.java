package com.we.controller;

import java.io.File;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import com.we.service.IService;
import com.we.service.Service;

public class Controller {
    private final IService service;
    private final File inventoryFile;

    @Autowired
    public Controller(Service service,File inventoryFile) {
		this.service = service;
		this.inventoryFile = inventoryFile;
    }
		
	public void start() {
		service.loadingInventory(inventoryFile);
        boolean readyToExit = false;
        Scanner scanner = new Scanner(System.in);
        while (!readyToExit) {
            System.out.println("\n========================================================");
            System.out.println("Vending Machine Application");
            System.out.println("========================================================");
            System.out.println("1 - Top up");
            System.out.println("2 - Purchase item");
            System.out.println("3 - Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1": // Top up
                    service.topUp();
                    break;
                case "2": // Purchase item
                    service.purchaseItem();
                    break;
                case "3": // Exit
                    service.writeInventory(inventoryFile);
                    service.viewAuditLog();
                    System.out.println("Goodbye!");
                    scanner.close();
                    readyToExit = true;
                    break;
                default:
                    System.out.println("Option not valid - try again !");
            }
        }
    }
}
