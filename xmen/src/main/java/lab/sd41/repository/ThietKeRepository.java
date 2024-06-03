package lab.sd41.repository;

import lab.sd41.entity.ThietKe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThietKeRepository extends JpaRepository<ThietKe, Long> {
}
