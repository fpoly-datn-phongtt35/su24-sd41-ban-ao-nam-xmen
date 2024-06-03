package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.Quyen;

import java.util.List;

@Repository
public interface QuyenRepo extends JpaRepository<Quyen, Long> {
    @Query("""
           from Quyen q join QuyenNguoiDung qnd on q.id = qnd.quyen.id where qnd.nguoiDung.id = :nguoiDungId
            """)
    List<Quyen> getAllQuyen(Long nguoiDungId);
}