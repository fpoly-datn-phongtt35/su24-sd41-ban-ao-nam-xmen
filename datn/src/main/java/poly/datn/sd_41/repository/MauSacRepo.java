package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.MauSac;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac, Long> {
    public boolean existsByTenMauEquals(String ten);
}