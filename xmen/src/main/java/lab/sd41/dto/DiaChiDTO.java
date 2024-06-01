package lab.sd41.dto;

import lab.sd41.entity.DiaChi;
import lab.sd41.entity.HoaDon;
import lab.sd41.entity.NguoiDung;
import lab.sd41.enums.TrangThaiDiaChi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiaChiDTO {
    private Long id;
    private NguoiDung nguoiDung;
    private String nguoiNhan;
    private String hoNguoiNhan;
    private String xaId;
    private String huyenId;
    private String tinhId;
    private String xa;
    private String huyen;
    private String tinh;
    private String chiTietDiaChi;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;
    private String soDienThoai;
    private Boolean laDiaChiChinh;
    private TrangThaiDiaChi trangThai;
    private List<HoaDon> hoaDonList;

    public static DiaChiDTO fromEntity(DiaChi entity) {
        return new DiaChiDTO(
                entity.getId(),
                entity.getNguoiDung(),
                entity.getNguoiNhan(),
                entity.getHoNguoiNhan(),
                entity.getXaId(),
                entity.getHuyenId(),
                entity.getTinhId(),
                entity.getXa(),
                entity.getHuyen(),
                entity.getTinh(),
                entity.getChiTietDiaChi(),
                entity.getNgayTao(),
                entity.getNgayCapNhat(),
                entity.getSoDienThoai(),
                entity.getLaDiaChiChinh(),
                entity.getTrangThai(),
                null
        );
    }

    public DiaChi toEntity() {
        return new DiaChi(
                this.getId(),
                this.getNguoiDung(),
                this.getNguoiNhan(),
                this.getHoNguoiNhan(),
                this.getXaId(),
                this.getHuyenId(),
                this.getTinhId(),
                this.getXa(),
                this.getHuyen(),
                this.getTinh(),
                this.getChiTietDiaChi(),
                this.getNgayTao(),
                this.getNgayCapNhat(),
                this.getSoDienThoai(),
                this.getLaDiaChiChinh(),
                this.getTrangThai(),
                null
        );
    }

    public static List<DiaChiDTO> fromCollection(List<DiaChi> collection) {
        List<DiaChiDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}
