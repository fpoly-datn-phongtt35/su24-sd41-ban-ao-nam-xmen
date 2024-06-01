package lab.sd41.dto;

import lab.sd41.entity.*;
import lab.sd41.enums.TrangThaiSanPhamChiTiet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamChiTietDTO {
    private Long id;
    private String maSanPham;
    private String tenSanPham;
    private Double giaNhap;
    private Double giaBan;
    private Integer soLuongTon;
    private Integer soLuongDaBan;
    private Integer soLuongLoi;
    private Integer soLuongTraHang;
    private TrangThaiSanPhamChiTiet trangThai;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;
    private MauSac mauSac;
    private KichThuoc kichThuoc;
    private SanPham sanPham;
    private String hinhAnh;
    private List<HoaDonChiTiet> hoaDonChiTietList;
    private List<GioHang> gioHangList;
    private List<SanPhamYeuThich> sanPhamYeuThichList;


    public static SanPhamChiTietDTO fromEntity(SanPhamChiTiet entity) {
        return new SanPhamChiTietDTO(
                entity.getId(),
                entity.getMaSanPham(),
                entity.getTenSanPham(),
                entity.getGiaNhap(),
                entity.getGiaBan(),
                entity.getSoLuongTon(),
                entity.getSoLuongDaBan(),
                entity.getSoLuongLoi(),
                entity.getSoLuongTraHang(),
                entity.getTrangThai(),
                entity.getNgayTao(),
                entity.getNgayCapNhat(),
                entity.getMauSac(),
                entity.getKichThuoc(),
                entity.getSanPham(),
                entity.getHinhAnh(),
                null,
                null,
                null
        );
    }

    public static List<SanPhamChiTietDTO> fromCollection(List<SanPhamChiTiet> collection) {
        List<SanPhamChiTietDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
