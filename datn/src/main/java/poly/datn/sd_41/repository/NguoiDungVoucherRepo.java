package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.NguoiDungVoucher;

@Repository
public interface NguoiDungVoucherRepo extends JpaRepository<NguoiDungVoucher, Long> {
}
