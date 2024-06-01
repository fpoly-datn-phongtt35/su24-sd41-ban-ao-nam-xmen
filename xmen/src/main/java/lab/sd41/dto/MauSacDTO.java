package lab.sd41.dto;

import lab.sd41.entity.MauSac;
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
public class MauSacDTO {
    private Long id;
    private String maMau;
    private String tenMau;
    private String maMauCss;
    private List<SanPhamChiTiet> sanPhamChiTietList;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;

    public static MauSacDTO fromEntity(MauSac entity) {
        return new MauSacDTO(
                entity.getId(),
                entity.getMaMau(),
                entity.getTenMau(),
                entity.getMaMauCss(),
                null,
                entity.getNgayTao(),
                entity.getNgayCapNhat()
        );
    }

    public static List<MauSacDTO> fromCollection(List<MauSac> collection) {
        List<MauSacDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
