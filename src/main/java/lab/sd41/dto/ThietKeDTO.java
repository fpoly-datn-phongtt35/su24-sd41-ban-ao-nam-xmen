package lab.sd41.dto;

import lab.sd41.entity.SanPham;
import lab.sd41.entity.ThietKe;
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
public class ThietKeDTO {
    private Long id;
    private String maThietKe;
    private String tenThietKe;
    private List<SanPham> sanPhamList;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;

    public static ThietKeDTO fromEntity(ThietKe entity) {
        return new ThietKeDTO(
                entity.getId(),
                entity.getMaThietKe(),
                entity.getTenThietKe(),
                null,
                entity.getNgayTao(),
                entity.getNgayCapNhat()
        );
    }

    public static List<ThietKeDTO> fromCollection(List<ThietKe> collection) {
        List<ThietKeDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
