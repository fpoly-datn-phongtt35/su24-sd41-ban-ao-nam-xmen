package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.XacNhan;

import java.util.Optional;

@Repository
public interface XacNhanRepository extends JpaRepository<XacNhan, Long> {
    public Optional<XacNhan> findXacNhanByCodeEquals(String code);
}