package lab.sd41.dto;

import lab.sd41.entity.HoaDon;
import lab.sd41.entity.HoaDonChiTiet;
import lab.sd41.entity.SanPhamChiTiet;
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
public class HoaDonChiTietDTO {
    private Long id;
    private HoaDon hoaDon;
    private SanPhamChiTiet sanPhamChiTiet;
    private Integer soLuong;
    private Double donGia;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;
    private Integer soLuongLoi;
    private Integer soLuongDoi;

    public static HoaDonChiTietDTO fromEntity(HoaDonChiTiet entity) {
        return new HoaDonChiTietDTO(
                entity.getId(),
                entity.getHoaDon(),
                entity.getSanPhamChiTiet(),
                entity.getSoLuong(),
                entity.getDonGia(),
                entity.getNgayTao(),
                entity.getNgayCapNhat(),
                entity.getSoLuongLoi(),
                entity.getSoLuongDoi()
        );
    }

    public static List<HoaDonChiTietDTO> fromCollection(List<HoaDonChiTiet> collection) {
        List<HoaDonChiTietDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
