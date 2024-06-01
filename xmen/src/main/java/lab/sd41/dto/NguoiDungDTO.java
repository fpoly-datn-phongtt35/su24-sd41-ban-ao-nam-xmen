package lab.sd41.dto;

import lab.sd41.entity.*;
import lab.sd41.enums.TrangThaiNguoiDung;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungDTO {
    private Long id;
    private String maNguoiDung;
    private String email;
    private String matKhau;
    private String ten;
    private String ho;
    private String anhDaiDien;
    private String soDienThoai;
    private Boolean gioiTinh;
    private Integer diem;
    private TrangThaiNguoiDung trangThai;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;
    private List<DiaChi> diaChiList;
    private List<GioHang> gioHangList;
    private List<HoaDon> danhSachMua;
    private List<HoaDon> danhSachHoaDonXacNhan;
    private List<NguoiDungVoucher> nguoiDungVoucherList;
    private List<QuyenNguoiDung> quyenNguoiDungList;
    private List<SanPhamYeuThich> sanPhamYeuThichList;
    List<Quyen> quyens;



}
