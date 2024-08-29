package com.devcamp.api.task_56cdot40_customer_invoice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56cdot40_customer_invoice.models.Customer;
import com.devcamp.api.task_56cdot40_customer_invoice.models.Invoice;

@Service
public class InvoiceService {
    private ArrayList<Invoice> invoices;
    private CustomerService customerService;

    public InvoiceService(CustomerService customerService) {
        this.customerService = customerService;
        this.invoices = new ArrayList<>();
        initializeData();
    }

    public void initializeData() {
        // Lay danh sach khach hang tu CustomerService
        List<Customer> customers = customerService.getAllCustomers();
        invoices.add(new Invoice(1, customers.get(0), 100.0));
        invoices.add(new Invoice(2, customers.get(1), 200.0));
        invoices.add(new Invoice(3, customers.get(2), 150.0));
    }

    public List<Invoice> getAllInvoices() {
        return invoices;
    }

    public Invoice getInvoiceById(int id) {
        return invoices.stream()
                .filter(invoice -> invoice.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
