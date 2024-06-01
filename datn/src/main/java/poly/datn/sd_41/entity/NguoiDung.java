package poly.datn.sd_41.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.enums.TrangThaiNguoiDung;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "nguoidung")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "manguoidung", unique = true)
    private String maNguoiDung;
    @Column(name = "email", columnDefinition = "nvarchar(max)")
    private String email;
    @Column(name = "matkhau", columnDefinition = "nvarchar(max)")
    private String matKhau;
    @Column(name = "ten", columnDefinition = "nvarchar(max)")
    private String ten;
    @Column(name = "ho", columnDefinition = "nvarchar(max)")
    private String ho;
    @Column(name = "anhdaidien")
    private String anhDaiDien;
    @Column(name = "sodienthoai")
    private String soDienThoai;
    @Column(name = "gioitinh")
    private Boolean gioiTinh;
    @Column(name = "diem")
    private Integer diem;
    @Column(name = "trangthai")
    private TrangThaiNguoiDung trangThai;
    @Column(name = "ngaytao")
    private LocalDateTime ngayTao;
    @Column(name = "ngaycapnhat")
    private LocalDateTime ngayCapNhat;
    @JoinColumn(name = "rankkhachhang")
    @ManyToOne
    @JsonIgnore
    private RankKhachHang rankKhachHang;
    @OneToMany(mappedBy = "nguoiDung")
    @JsonIgnore
    private List<BinhLuanDanhGia> binhLuanDanhGiaList;
    @OneToMany(mappedBy = "nguoiDung")
    @JsonIgnore
    private List<DiaChi> diaChiList;
    @OneToMany(mappedBy = "nguoiMua")
    @JsonIgnore
    private List<GioHang> gioHangList;
    @OneToMany(mappedBy = "nguoiMua")
    @JsonIgnore
    private List<HoaDon> danhSachMua;
    @OneToMany(mappedBy = "nhanVien")
    @JsonIgnore
    private List<HoaDon> danhSachHoaDonXacNhan;
    @OneToMany(mappedBy = "nguoiDung")
    @JsonIgnore
    private List<NguoiDungVoucher> nguoiDungVoucherList;
    @OneToMany(mappedBy = "nguoiDung")
    @JsonIgnore
    private List<QuyenNguoiDung> quyenNguoiDungList;
    @OneToMany(mappedBy = "nguoiDung")
    @JsonIgnore
    private List<SanPhamYeuThich> sanPhamYeuThichList;
}
