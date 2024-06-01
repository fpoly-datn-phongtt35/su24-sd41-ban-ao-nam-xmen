package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.HinhAnhSanPham;

@Repository
public interface HinhAnhSanPhamRepository extends JpaRepository<HinhAnhSanPham,Long> {
}
