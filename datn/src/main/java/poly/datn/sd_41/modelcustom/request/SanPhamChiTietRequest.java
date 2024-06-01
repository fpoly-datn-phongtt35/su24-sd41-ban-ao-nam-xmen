package poly.datn.sd_41.modelcustom.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.enums.TrangThaiSanPhamChiTiet;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamChiTietRequest {
    private Long id;
    private Double giaNhap;
    private Double giaBan;
    private Integer soLuongTon;
    private Integer soLuongDaBan;
    private Integer soLuongLoi;
    private Integer soLuongTraHang;
    private TrangThaiSanPhamChiTiet trangThai;
    private String hinhAnh;
    private Long mauSacId;
    private Long kichThuocId;
    private Long sanPhamId;
}