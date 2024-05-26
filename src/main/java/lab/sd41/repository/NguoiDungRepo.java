package lab.sd41.repository;


import lab.sd41.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NguoiDungRepo extends JpaRepository<NguoiDung, Long> {
    @Query("SELECT a FROM NguoiDung a JOIN QuyenNguoiDung b ON b.nguoiDung.id = a.id WHERE b.quyen.id = 2 and  a.trangThai = 0")
    List<NguoiDung> getAllTangVoucher();

    public Optional<NguoiDung> findNguoiDungByEmailEquals(String email);
}
