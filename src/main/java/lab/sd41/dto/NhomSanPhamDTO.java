package lab.sd41.dto;

import lab.sd41.entity.NhomSanPham;
import lab.sd41.entity.SanPham;
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
public class NhomSanPhamDTO {
    private Long id;
    private String maNhom;
    private String tenNhom;
    private List<SanPham> sanPhamList;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;

    public static NhomSanPhamDTO fromEntity(NhomSanPham entity) {
        return new NhomSanPhamDTO(
                entity.getId(),
                entity.getMaNhom(),
                entity.getTenNhom(),
                null,
                entity.getNgayTao(),
                entity.getNgayCapNhat()
        );
    }

    public static List<NhomSanPhamDTO> fromCollection(List<NhomSanPham> collection) {
        List<NhomSanPhamDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
