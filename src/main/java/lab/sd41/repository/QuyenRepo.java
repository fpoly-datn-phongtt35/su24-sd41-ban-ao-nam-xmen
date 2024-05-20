package lab.sd41.repository;

import lab.sd41.entity.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenRepo extends JpaRepository<Quyen, Long> {

}
