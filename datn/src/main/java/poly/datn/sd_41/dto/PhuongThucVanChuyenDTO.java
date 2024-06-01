package poly.datn.sd_41.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.entity.HoaDon;
import poly.datn.sd_41.entity.PhuongThucVanChuyen;
import poly.datn.sd_41.enums.TrangThaiPhuongThucThanhToan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhuongThucVanChuyenDTO {
    private Long id;
    private String maPhuongThuc;
    private String tenPhuongThuc;
    private TrangThaiPhuongThucThanhToan trangThai;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;
    private List<HoaDon> hoaDonList;

    public static PhuongThucVanChuyenDTO fromEntity(PhuongThucVanChuyen entity) {
        return new PhuongThucVanChuyenDTO(
                entity.getId(),
                entity.getMaPhuongThuc(),
                entity.getTenPhuongThuc(),
                entity.getTrangThai(),
                entity.getNgayTao(),
                entity.getNgayCapNhat(),
                null
        );
    }

    public static List<PhuongThucVanChuyenDTO> fromCollection(List<PhuongThucVanChuyen> collection) {
        List<PhuongThucVanChuyenDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
