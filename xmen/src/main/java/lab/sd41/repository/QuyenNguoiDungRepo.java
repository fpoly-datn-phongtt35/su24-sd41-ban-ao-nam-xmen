package lab.sd41.repository;


import lab.sd41.entity.QuyenNguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenNguoiDungRepo extends JpaRepository<QuyenNguoiDung, Long> {


}
