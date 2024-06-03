package poly.datn.sd_41.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.enums.TrangThaiPhuongThucThanhToan;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "phuongthucvanchuyen")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhuongThucVanChuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "maphuongthuc", unique = true)
    private String maPhuongThuc;
    @Column(name = "tenphuongthuc", columnDefinition = "nvarchar(max)")
    private String tenPhuongThuc;
    @Column(name = "trangthai")
    private TrangThaiPhuongThucThanhToan trangThai;
    @OneToMany(mappedBy = "phuongThucVanChuyen")
    @JsonIgnore
    private List<HoaDon> hoaDonList;
    @Column(name = "ngaytao")
    private LocalDateTime ngayTao;
    @Column(name = "ngaycapnhat")
    private LocalDateTime ngayCapNhat;
}