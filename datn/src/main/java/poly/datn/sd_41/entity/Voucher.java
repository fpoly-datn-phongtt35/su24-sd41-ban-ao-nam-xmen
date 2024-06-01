package poly.datn.sd_41.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.enums.TrangThaiVoucher;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "voucher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class    Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mavoucher", unique = true)
    private String maVoucher;
    @Column(name = "tenvoucher", columnDefinition = "nvarchar(max)")
    private String tenVoucher;
    @Column(name = "giatrigiam")
    private Double giaTriGiam;
    @Column(name = "ngaytao")
    private LocalDateTime ngayTao;
    @Column(name = "ngaycapnhat")
    private LocalDateTime ngayCapNhat;
    @Column(name = "ngayketthuc")
    private LocalDateTime ngayKetThuc;
    @Column(name = "soluong")
    private Integer soLuong;
    @Column(name = "trangthai")
    private TrangThaiVoucher trangThai;
    @OneToMany(mappedBy = "voucher")
    @JsonIgnore
    private List<NguoiDungVoucher> nguoiDungVoucherList;
}
