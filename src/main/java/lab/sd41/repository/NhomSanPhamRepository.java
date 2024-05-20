package lab.sd41.repository;

import lab.sd41.entity.NhomSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhomSanPhamRepository extends JpaRepository<NhomSanPham, Long> {


}
