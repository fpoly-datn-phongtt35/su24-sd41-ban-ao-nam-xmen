package lab.sd41.repository;

import lab.sd41.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiaChiRepo extends JpaRepository<DiaChi, Long> {
}