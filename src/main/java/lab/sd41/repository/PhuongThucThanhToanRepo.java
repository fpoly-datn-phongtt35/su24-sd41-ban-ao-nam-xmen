package lab.sd41.repository;

import lab.sd41.entity.PhuongThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhuongThucThanhToanRepo extends JpaRepository<PhuongThucThanhToan, Long> {
}
