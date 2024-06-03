package poly.datn.sd_41.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.enums.TrangThaiDiaChi;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "diachi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "nguoidungid")
    @ManyToOne
    @JsonIgnore
    private NguoiDung nguoiDung;
    @Column(name = "nguoinhan",columnDefinition = "nvarchar(max)")
    private String nguoiNhan;
    @Column(name = "honguoinhan",columnDefinition = "nvarchar(max)")
    private String hoNguoiNhan;
    @Column(name = "xaid")
    private String xaId;
    @Column(name = "huyenid")
    private String huyenId;
    @Column(name = "tinhid")
    private String tinhId;
    @Column(name = "xa",columnDefinition = "nvarchar(max)")
    private String xa;
    @Column(name = "huyen",columnDefinition = "nvarchar(max)")
    private String huyen;
    @Column(name = "tinh",columnDefinition = "nvarchar(max)")
    private String tinh;
    @Column(name = "chitietdiachi", columnDefinition = "nvarchar(max)")
    private String chiTietDiaChi;
    @Column(name = "ngaytao")
    private LocalDateTime ngayTao;
    @Column(name = "ngaycapnhat")
    private LocalDateTime ngayCapNhat;
    @Column(name = "sodienthoai")
    private String soDienThoai;
    @Column(name = "ladiachichinh")
    private Boolean laDiaChiChinh;
    @Column(name = "trangthai")
    private TrangThaiDiaChi trangThai;
    @OneToMany(mappedBy = "diaChiGiao")
    @JsonIgnore
    private List<HoaDon> hoaDonList;
}
