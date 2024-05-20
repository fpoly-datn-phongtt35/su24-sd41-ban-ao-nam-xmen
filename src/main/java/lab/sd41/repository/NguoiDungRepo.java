package lab.sd41.repository;


import lab.sd41.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepo extends JpaRepository<NguoiDung, Long> {


}
