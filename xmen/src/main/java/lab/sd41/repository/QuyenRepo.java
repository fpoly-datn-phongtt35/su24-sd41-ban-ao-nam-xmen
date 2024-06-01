package lab.sd41.repository;

import lab.sd41.entity.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuyenRepo extends JpaRepository<Quyen, Long> {
    @Query("""
           from Quyen q join QuyenNguoiDung qnd on q.id = qnd.quyen.id where qnd.nguoiDung.id = :nguoiDungId
            """)
    List<Quyen> getAllQuyen(Long nguoiDungId);
}
