package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.ThietKe;

@Repository
public interface ThietKeRepository extends JpaRepository<ThietKe,Long> {
    public boolean existsByTenThietKeEquals(String ten);
}