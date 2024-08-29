package com.devcamp.api.task_64dot10_crud_vouchers.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CVoucherDto {
    private long id;

    @NotNull(message = "Nhập mã giảm giá")
    @Size(min = 2, message = "Mã voucher phải có ít nhất 2 ký tự ")
    private String maVoucher;

    @NotEmpty(message = "Nhập giá trị giảm giá")
    // @Range(min=1, max=99, message = "Nhập giá trị từ 1 đến 99")
    private String phanTramGiamGia;

    private String ghiChu;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(String phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
