package com.devcamp.api.task_56ddot60custumer_invoice.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56ddot60custumer_invoice.models.Customer;
import com.devcamp.api.task_56ddot60custumer_invoice.models.Invoice;
import com.devcamp.api.task_56ddot60custumer_invoice.services.CustomerService;
import com.devcamp.api.task_56ddot60custumer_invoice.services.InvoiceService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerInvoiceController {
    private final InvoiceService invoiceService;
    private final CustomerService customerService;

    @Autowired
    public CustomerInvoiceController(InvoiceService invoiceService, CustomerService customerService) {
        this.invoiceService = invoiceService;
        this.customerService = customerService;
    }

    @GetMapping("/task_56ddot60/customers")
    public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
        ArrayList<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/task_56ddot60/invoices")
    public ResponseEntity<ArrayList<Invoice>> getAllInvoices() {
        ArrayList<Invoice> invoices = invoiceService.getAllInvoices();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/task_56ddot60/invoices/{invoiceId}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("invoiceId") int invoiceId) {
        ArrayList<Invoice> invoices = invoiceService.getAllInvoices();

        if (invoiceId < 0 || invoiceId >= invoices.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Invoice invoice = invoices.get(invoiceId);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }
}
