package com.devcamp.api.task_64dot30_crud_drinks.models;

import java.util.*;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;;

@Entity
@Table(name = "drinks")
@EntityListeners(AuditingEntityListener.class)
public class CDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Nhap ma nuoc uong")
    @Size(min = 2, message = "Ma nuoc uong co it nhat 2 ky tu")
    @Column(name = "ma_nuoc_uong", unique = true)
    private String maNuocUong;

    @NotNull(message = "Nhap ten nuoc uong")
    @Size(min = 2, message = "Ten nuoc uong co it nhat 2 ky tu")
    @Column(name = "ten_nuoc_uong")
    private String tenNuocUong;

    @NotNull(message = "Nhap don gia")
    @Range(min = 10000, max = 50000, message = "Don gia pha tu 10k den 50k")
    @Column(name = "don_gia")
    private long donGia;

    @Column(name = "ghi_chu", nullable = true)
    private String ghiChu;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao", nullable = true, updatable = false)
    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date ngayTao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_cap_nhat", nullable = true)
    @LastModifiedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date ngayCapNhat;

    public CDrink() {
        super();
    }

    public CDrink(long id,
            String maNuocUong,
            String tenNuocUong,
            long donGia,
            String ghiChu, Date ngayTao, Date ngayCapNhat) {
        this.id = id;
        this.maNuocUong = maNuocUong;
        this.tenNuocUong = tenNuocUong;
        this.donGia = donGia;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaNuocUong() {
        return maNuocUong;
    }

    public void setMaNuocUong(String maNuocUong) {
        this.maNuocUong = maNuocUong;
    }

    public String getTenNuocUong() {
        return tenNuocUong;
    }

    public void setTenNuocUong(String tenNuocUong) {
        this.tenNuocUong = tenNuocUong;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

}
