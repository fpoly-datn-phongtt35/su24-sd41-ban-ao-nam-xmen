package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.NguoiDung;

import java.util.Optional;

@Repository
public interface NguoiDungRepo extends JpaRepository<NguoiDung, Long> {
    public Optional<NguoiDung> findNguoiDungByEmailEquals(String email);
}
