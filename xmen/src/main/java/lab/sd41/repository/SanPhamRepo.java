package lab.sd41.repository;

import lab.sd41.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Long> {


}
