package com.devcamp.api.task_56ddot60custumer_invoice.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56ddot60custumer_invoice.models.Customer;
import com.devcamp.api.task_56ddot60custumer_invoice.models.Invoice;

@Service
public class InvoiceService {
    private ArrayList<Invoice> invoices;

    public InvoiceService() {
        invoices = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        CustomerService customerService = new CustomerService();

        // Lấy danh sách khách hàng từ CustomerService
        ArrayList<Customer> customers = customerService.getAllCustomers();

        // Tạo các hóa đơn mẫu tương ứng với từng khách hàng
        Invoice invoice1 = new Invoice(0, customers.get(0), 1000.0);
        Invoice invoice2 = new Invoice(1, customers.get(1), 2000.0);
        Invoice invoice3 = new Invoice(2, customers.get(2), 3000.0);

        // Thêm các hóa đơn vào danh sách invoices
        invoices.add(invoice1);
        invoices.add(invoice2);
        invoices.add(invoice3);
    }

    public ArrayList<Invoice> getAllInvoices() {
        return invoices;
    }
}
