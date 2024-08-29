package com.devcamp.api.task_56cdot40_customer_invoice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56cdot40_customer_invoice.models.Customer;
import com.devcamp.api.task_56cdot40_customer_invoice.models.Invoice;
import com.devcamp.api.task_56cdot40_customer_invoice.services.CustomerService;
import com.devcamp.api.task_56cdot40_customer_invoice.services.InvoiceService;

@RestController
@RequestMapping()
@CrossOrigin
public class InvoiceController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        if (invoiceService != null) {
            List<Invoice> invoices = invoiceService.getAllInvoices();
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
