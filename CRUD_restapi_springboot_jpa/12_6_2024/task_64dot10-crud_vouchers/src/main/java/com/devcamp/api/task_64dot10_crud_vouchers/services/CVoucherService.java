package com.devcamp.api.task_64dot10_crud_vouchers.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.internal.lang.annotation.ajcDeclareSoft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_64dot10_crud_vouchers.models.CVoucher;
import com.devcamp.api.task_64dot10_crud_vouchers.repositories.IVoucherRepository;

@Service
public class CVoucherService {
    @Autowired
    IVoucherRepository pVoucherRepository;

    public List<CVoucher> getVoucherList() {
        List<CVoucher> listCVoucher = new ArrayList<>();
        pVoucherRepository.findAll().forEach(listCVoucher::add);
        return listCVoucher;
    }

    public List<CVoucher> getAllVouchers() {
        return pVoucherRepository.findAll();
    }

    public Optional<CVoucher> getVoucherById(Long id) {
        return pVoucherRepository.findById(id);
    }

    public CVoucher createVoucher(CVoucher newVoucher) {
        return pVoucherRepository.save(newVoucher);
    }

    public CVoucher udpateVoucher(CVoucher voucher){
        return pVoucherRepository.save(voucher);
    }

    public void deleteVoucher(Long id) {
        pVoucherRepository.deleteById(id);
    }

    public void deleteAllVoucher() {
        pVoucherRepository.deleteAll();
    }

}
