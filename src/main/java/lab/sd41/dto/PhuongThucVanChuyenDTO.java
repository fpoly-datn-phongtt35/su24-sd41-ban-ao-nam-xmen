package lab.sd41.dto;

import lab.sd41.entity.HoaDon;
import lab.sd41.entity.PhuongThucVanChuyen;
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
public class PhuongThucVanChuyenDTO {
    private Long id;
    private String maPhuongThuc;
    private String tenPhuongThuc;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;
    private List<HoaDon> hoaDonList;

    public static PhuongThucVanChuyenDTO fromEntity(PhuongThucVanChuyen entity) {
        return new PhuongThucVanChuyenDTO(
                entity.getId(),
                entity.getMaPhuongThuc(),
                entity.getTenPhuongThuc(),
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
