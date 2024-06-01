package lab.sd41.dto;

import lab.sd41.entity.KichThuoc;
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
public class KichThuocDTO {
    private Long id;
    private String maKichThuoc;
    private String tenKichThuoc;
    private List<SanPhamChiTiet> sanPhamChiTietList;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;

    public static KichThuocDTO fromEntity(KichThuoc entity) {
        return new KichThuocDTO(
                entity.getId(),
                entity.getMaKichThuoc(),
                entity.getTenKichThuoc(),
                null,
                entity.getNgayTao(),
                entity.getNgayCapNhat()
        );
    }

    public static List<KichThuocDTO> fromCollection(List<KichThuoc> collection) {
        List<KichThuocDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
