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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YeuThichDTO {
    private Long id;
    private NguoiDung nguoiMua;
    private SanPhamChiTiet sanPhamChiTiet;
    private LocalDateTime ngayCapNhat;

    public static YeuThichDTO fromEntity(SanPhamYeuThich entity) {
        NguoiDung ng = entity.getNguoiDung();
        ng.setMatKhau("");
        return new YeuThichDTO(
                entity.getId(),
                ng,
                entity.getSanPhamChiTiet(),
                entity.getNgayCapNhat()
        );
    }

    public static List<YeuThichDTO> fromCollection(List<SanPhamYeuThich> collection) {
        List<YeuThichDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}

