package poly.datn.sd_41.modelcustom.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.enums.TrangThaiSanPham;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamRequest {
    private Long id;
    private String tenSanPham;
    private Double giaNhap;
    private Double giaBan;
    private String moTa;
    private Long nhomSanPhamId;
    private Long thietKeId;
    private Long chatLieuId;
    private TrangThaiSanPham trangThai;
}