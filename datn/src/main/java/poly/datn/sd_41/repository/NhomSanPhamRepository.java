package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.NhomSanPham;

@Repository
public interface NhomSanPhamRepository extends JpaRepository<NhomSanPham,Long> {
    public boolean existsByTenNhomEquals(String ten);
}
