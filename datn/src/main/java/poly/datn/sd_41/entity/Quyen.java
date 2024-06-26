package poly.datn.sd_41.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quyen")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "maquyen",unique = true)
    private String maQuyen;
    @Column(name = "tenquyen",columnDefinition = "nvarchar(max)")
    private String tenQuyen;
    @OneToMany(mappedBy = "quyen")
    @JsonIgnore
    private List<QuyenNguoiDung> quyenNguoiDungList;
    @Column(name = "ngaytao")
    private LocalDateTime ngayTao;
    @Column(name = "ngaycapnhat")
    private LocalDateTime ngayCapNhat;
}