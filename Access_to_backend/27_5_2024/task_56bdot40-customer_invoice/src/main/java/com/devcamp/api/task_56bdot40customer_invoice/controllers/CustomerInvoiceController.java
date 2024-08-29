package com.devcamp.api.task_56bdot40customer_invoice.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56bdot40customer_invoice.models.Customer;
import com.devcamp.api.task_56bdot40customer_invoice.models.Invoice;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerInvoiceController {
    @GetMapping("/task_56b.40/invoices")
    public ArrayList<Invoice> getListInvoice() {
        Customer customer1 = new Customer(1, "Customer 1", 10);
        Customer customer2 = new Customer(2, "Customer 2", 15);
        Customer customer3 = new Customer(3, "Customer 3", 20);

        // In thông tin 3 đối tượng khách hàng ra console
        System.out.println(customer1.toString());
        System.out.println(customer2.toString());
        System.out.println(customer3.toString());

        // Khởi tạo 3 đối tượng hóa đơn tương ứng với 3 khách hàng
        Invoice invoice1 = new Invoice(1, customer1, 100.0);
        Invoice invoice2 = new Invoice(2, customer2, 200.0);
        Invoice invoice3 = new Invoice(3, customer3, 300.0);

        System.out.println(invoice1.toString());
        System.out.println(invoice2.toString());
        System.out.println(invoice3.toString());

        // Khởi tạo một ArrayList mới để chứa các đối tượng hóa đơn
        ArrayList<Invoice> invoiceList = new ArrayList<>();

        // Thêm các đối tượng hóa đơn vào ArrayList
        invoiceList.add(invoice1);
        invoiceList.add(invoice2);
        invoiceList.add(invoice3);

        // Trả về ArrayList chứa các đối tượng hóa đơn
        return invoiceList;
    }
}
