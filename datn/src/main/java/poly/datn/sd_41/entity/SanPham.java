package poly.datn.sd_41.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.enums.TrangThaiSanPham;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sanpham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "masanpham", unique = true)
    private String maSanPham;
    @Column(name = "tensanpham", columnDefinition = "nvarchar(max)")
    private String tenSanPham;
    @Column(name = "hinhanh1")
    private String hinhAnh1;
    @Column(name = "hinhanh2")
    private String hinhAnh2;
    @Column(name = "gianhap")
    private Double giaNhap;
    @Column(name = "giaban")
    private Double giaBan;
    @Column(name = "ngaytao")
    private LocalDateTime ngayTao;
    @Column(name = "ngaycapnhat")
    private LocalDateTime ngayCapNhat;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "trangthai")
    private TrangThaiSanPham trangThai;
    @Column(name = "soluongton")
    private Integer soLuongTon;
    @Column(name = "soluongdaban")
    private Integer soLuongDaBan;
    @Column(name = "soluongtrahang")
    private Integer soLuongTraHang;
    @Column(name = "soluongloi")
    private Integer soLuongLoi;

    @JoinColumn(name = "thietkeid")
    @ManyToOne
    @JsonIgnore
    private ThietKe thietKe;
    @JoinColumn(name = "nhomsanphamid")
    @ManyToOne
//    @JsonIgnore
    private NhomSanPham nhomSanPham;
    @JoinColumn(name = "chatlieuid")
    @ManyToOne
    @JsonIgnore
    private ChatLieu chatLieu;
    @OneToMany(mappedBy = "sanPham")
    @JsonIgnore
    private List<HinhAnhSanPham> hinhAnhSanPhamList;
    @OneToMany(mappedBy = "sanPham")
    @JsonIgnore
    private List<SanPhamChiTiet> sanPhamChiTietList;
}
