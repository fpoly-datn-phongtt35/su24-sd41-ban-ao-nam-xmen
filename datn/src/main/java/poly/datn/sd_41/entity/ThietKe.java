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
@Table(name = "thietke")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThietKe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mathietke")
    private String maThietKe;
    @Column(name = "tenthietke",columnDefinition = "nvarchar(max)")
    private String tenThietKe;
    @OneToMany(mappedBy = "thietKe")
    @JsonIgnore
    private List<SanPham> sanPhamList;
    @Column(name = "ngaytao")
    private LocalDateTime ngayTao;
    @Column(name = "ngaycapnhat")
    private LocalDateTime ngayCapNhat;
}
