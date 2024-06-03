package poly.datn.sd_41.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.entity.GioHang;
import poly.datn.sd_41.entity.NguoiDung;
import poly.datn.sd_41.entity.SanPhamChiTiet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHangDTO {
    private Long id;
    private NguoiDung nguoiMua;
    private SanPhamChiTiet sanPhamChiTiet;
    private Integer soLuong;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;

    public static GioHangDTO fromEntity(GioHang entity) {
        NguoiDung ng = entity.getNguoiMua();
        ng.setMatKhau("");
        return new GioHangDTO(
                entity.getId(),
                ng,
                entity.getSanPhamChiTiet(),
                entity.getSoLuong(),
                entity.getNgayTao(),
                entity.getNgayCapNhat()
        );
    }

    public static List<GioHangDTO> fromCollection(List<GioHang> collection) {
        List<GioHangDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}

