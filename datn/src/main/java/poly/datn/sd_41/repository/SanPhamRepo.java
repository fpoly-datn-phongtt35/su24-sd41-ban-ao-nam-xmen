package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.NhomSanPham;
import poly.datn.sd_41.entity.SanPham;
import poly.datn.sd_41.entity.ThietKe;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Long> {
    public boolean existsByNhomSanPham(NhomSanPham nhomSanPham);

    public boolean existsByThietKe(ThietKe thietKe);
}
