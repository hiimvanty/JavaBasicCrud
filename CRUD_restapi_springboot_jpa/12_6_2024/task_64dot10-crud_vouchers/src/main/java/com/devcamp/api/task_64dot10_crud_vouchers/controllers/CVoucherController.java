package com.devcamp.api.task_64dot10_crud_vouchers.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_64dot10_crud_vouchers.models.CVoucher;
import com.devcamp.api.task_64dot10_crud_vouchers.services.CVoucherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CVoucherController {

    @Autowired
    private CVoucherService vService;

    /*
     * POST /api/vouchers create new Voucher
     * GET /api/vouchers retrieve all Voucher
     * GET /api/vouchers/:id retrieve a Voucher by :id
     * PUT /api/vouchers/:id update a Voucher by :id
     * DELETE /api/vouchers/:id delete a Voucher by :id
     * DELETE /api/vouchers delete all Voucher
     * 
     */
    @GetMapping("/vouchers")
    public ResponseEntity<List<CVoucher>> getAllVoucher() {
        try {
            return new ResponseEntity<List<CVoucher>>(vService.getAllVouchers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<CVoucher>>(HttpStatus.NOT_FOUND);
        }
    }

    // /api/vouchers/2
    @GetMapping("/vouchers/{id}")
    public ResponseEntity<CVoucher> getVoucherById(@PathVariable("id") Long id) {
        try {
            Optional<CVoucher> optVoucher = vService.getVoucherById(id);
            if (optVoucher.isPresent()) {
                return new ResponseEntity<CVoucher>(optVoucher.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<CVoucher>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<CVoucher>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/vouchers")
    public ResponseEntity<CVoucher> createVoucher(@Valid @RequestBody CVoucher voucher) {
        try {
            CVoucher newVoucher = new CVoucher();
            newVoucher.setMaVoucher(voucher.getMaVoucher());
            newVoucher.setPhanTramGiamGia(voucher.getPhanTramGiamGia());
            newVoucher.setGhiChu(voucher.getGhiChu());
            newVoucher.setNgayTao(new Date());

            newVoucher = vService.createVoucher(newVoucher);
            return new ResponseEntity<CVoucher>(newVoucher, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<CVoucher>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/vouchers/{id}")
    public ResponseEntity<CVoucher> updateVoucher(@Valid @PathVariable("id") Long id, @RequestBody CVoucher voucher) {
        try {
            Optional<CVoucher> optVoucher = vService.getVoucherById(id);
            if (optVoucher.isPresent()) {
                CVoucher updateVoucher = optVoucher.get();
                updateVoucher.setPhanTramGiamGia(voucher.getPhanTramGiamGia());
                updateVoucher.setGhiChu(voucher.getGhiChu());
                updateVoucher.setMaVoucher(voucher.getMaVoucher());
                updateVoucher.setNgayCapNhat(new Date());

                updateVoucher = vService.udpateVoucher(updateVoucher);
                return new ResponseEntity<CVoucher>(updateVoucher, HttpStatus.OK);
            } else {
                return new ResponseEntity<CVoucher>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<CVoucher>(HttpStatus.NO_CONTENT);
        }
    }   

    @DeleteMapping("vouchers/{id}")
    public ResponseEntity<String> deleteVoucher(@PathVariable("id") Long id) {
        try {
            vService.deleteVoucher(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
    }
}
