package lab.sd41.dto;

import lab.sd41.entity.GioHang;
import lab.sd41.entity.NguoiDung;
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
