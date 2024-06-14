package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.KichThuoc;
import poly.datn.sd_41.entity.MauSac;
import poly.datn.sd_41.entity.SanPham;
import poly.datn.sd_41.entity.SanPhamChiTiet;

import java.util.List;
import java.util.Optional;

@Repository
public interface SanPhamChiTietRepo extends JpaRepository<SanPhamChiTiet, Long> {
    public List<SanPhamChiTiet> findSanPhamChiTietsBySanPham(SanPham sanPham);

    public Optional<SanPhamChiTiet> findSanPhamChiTietByMaSanPham(String maSanPham);

    public List<SanPhamChiTiet> findSanPhamChiTietsByMauSacAndKichThuocAndSanPham(MauSac mauSac, KichThuoc kichThuoc, SanPham sanPham);

    public boolean existsByMauSac(MauSac mauSac);

    public boolean existsByKichThuoc(KichThuoc kichThuoc);
}
