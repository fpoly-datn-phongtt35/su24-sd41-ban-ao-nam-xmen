package poly.datn.sd_41.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.entity.NguoiDung;
import poly.datn.sd_41.entity.SanPhamChiTiet;
import poly.datn.sd_41.entity.SanPhamYeuThich;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamYeuThichDTO {
    private Long id;
    private NguoiDung nguoiDung;
    private SanPhamChiTiet sanPhamChiTiet;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;

    public static SanPhamYeuThichDTO fromEntity(SanPhamYeuThich entity) {
        return new SanPhamYeuThichDTO(entity.getId(), entity.getNguoiDung(), entity.getSanPhamChiTiet(), entity.getNgayTao(), entity.getNgayCapNhat());
    }

    public static List<SanPhamYeuThichDTO> fromCollection(List<SanPhamYeuThich> collection) {
        List<SanPhamYeuThichDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
