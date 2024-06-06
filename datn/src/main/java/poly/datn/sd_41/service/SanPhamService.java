package poly.datn.sd_41.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import poly.datn.sd_41.common.Page;
import poly.datn.sd_41.common.ResponObject;
import poly.datn.sd_41.dto.*;
import poly.datn.sd_41.entity.*;
import poly.datn.sd_41.enums.APIStatus;
import poly.datn.sd_41.iservice.ISanPhamService;
import poly.datn.sd_41.modelcustom.reponse.FullThuocTinh;
import poly.datn.sd_41.modelcustom.request.FilterSanPham;
import poly.datn.sd_41.modelcustom.request.SanPhamChiTietRequest;
import poly.datn.sd_41.modelcustom.request.SanPhamRequest;
import poly.datn.sd_41.repository.ChatLieuRepository;
import poly.datn.sd_41.repository.NhomSanPhamRepository;
import poly.datn.sd_41.repository.SanPhamRepo;
import poly.datn.sd_41.repository.ThietKeRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SanPhamService implements ISanPhamService {
    @Autowired
    private SanPhamRepo _sanPhamRepository;
    @Autowired
    private ChatLieuRepository _chatLieuRepo;
    @Autowired
    private NhomSanPhamRepository _nhomSanPhamRepo;
    @Autowired
    private ThietKeRepository _thietKeRepo;

    @Override
    public SanPham findById(Long id) {
        return _sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public Page<SanPhamDTO> phanTrangSanPhamTrangChu(Integer page, Integer pageSize, Long chatLieuId, Long thietKeId, Long thuongHieuId, Long mauSacId, Long loaiSanPhamId, Long kichThuocId, String keyWord) {
        return null;
    }

    @Override
    public Page<SanPhamDTO> phanTrangSanPhamTrangChu(Integer page, Integer pageSize, FilterSanPham filterSanPham) {
        return null;
    }

    @Override
    public SanPhamChiTiet chiTietSanPham(Long sanPhamId) {
        Optional<SanPham> sp = _sanPhamRepository.findById(sanPhamId);
        if (sp.isEmpty()) {
            return null;
        }
        return new SanPhamChiTiet(SanPhamDTO.fromEntity(sp.get()), SanPhamChiTietDTO.fromCollection(_sanPhamChiTietRepository.findSanPhamChiTietsBySanPham(sp.get())));
    }

    @Override
    public Page<ChatLieuDTO> layHetChatLieu() {
        return new Page<ChatLieuDTO>(ChatLieuDTO.fromCollection(_chatLieuRepo.findAll()), 0, 10000);
    }

    @Override
    public Page<ChatLieuDTO> xoaChatLieu(Long chatLieuId) {
        try {
            _chatLieuRepo.deleteById(chatLieuId);
            return layHetChatLieu();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Page<ChatLieuDTO> suaChatLieu(ChatLieu chatLieu) {
        if (_chatLieuRepo.existsByTenChatLieuContains(chatLieu.getTenChatLieu())) {
            return null;
        }
        ChatLieu chatLieuGoc = _chatLieuRepo.findById(chatLieu.getId()).get();
        chatLieuGoc.setTenChatLieu(chatLieu.getTenChatLieu());
        chatLieuGoc.setNgayCapNhat(LocalDateTime.now());
        _chatLieuRepo.save(chatLieuGoc);
        return layHetChatLieu();
    }

    @Override
    public Page<ChatLieuDTO> themChatLieu(ChatLieu chatLieu) {
        if (_chatLieuRepo.existsByTenChatLieuContains(chatLieu.getTenChatLieu())) {
            return null;
        }
        chatLieu.setNgayTao(LocalDateTime.now());
        _chatLieuRepo.save(chatLieu);
        chatLieu.setMaChatLieu("CL" + chatLieu.getId());
        _chatLieuRepo.save(chatLieu);
        return layHetChatLieu();
    }

    @Override
    public Page<NhomSanPhamDTO> layHetNhomSanPham() {
        return new Page<NhomSanPhamDTO>(NhomSanPhamDTO.fromCollection(_nhomSanPhamRepo.findAll()), 0, 10000);
    }

    @Override
    public Page<NhomSanPhamDTO> xoaNhomSanPham(Long nhomSanPhamId) {
        NhomSanPham nhomSanPham = _nhomSanPhamRepo.findById(nhomSanPhamId).get();
        if (_sanPhamRepository.existsByNhomSanPham(nhomSanPham)) {
            return null;
        }
        _nhomSanPhamRepo.deleteById(nhomSanPhamId);
        return layHetNhomSanPham();
    }

    @Override
    public Page<NhomSanPhamDTO> suaNhomSanPham(NhomSanPham nhomSanPham) {
        if (_nhomSanPhamRepo.existsByTenNhomEquals(nhomSanPham.getTenNhom())) {
            return null;
        }
        NhomSanPham nhomSanPhamGoc = _nhomSanPhamRepo.findById(nhomSanPham.getId()).get();
        nhomSanPhamGoc.setTenNhom(nhomSanPham.getTenNhom());
        nhomSanPhamGoc.setNgayCapNhat(LocalDateTime.now());
        _nhomSanPhamRepo.save(nhomSanPhamGoc);
        return layHetNhomSanPham();
    }

    @Override
    public Page<NhomSanPhamDTO> themNhomSanPham(NhomSanPham nhomSanPham) {
        if (_nhomSanPhamRepo.existsByTenNhomEquals(nhomSanPham.getTenNhom())) {
            return null;
        }
        nhomSanPham.setNgayTao(LocalDateTime.now());
        _nhomSanPhamRepo.save(nhomSanPham);
        nhomSanPham.setMaNhom("NSP" + nhomSanPham.getId());
        _nhomSanPhamRepo.save(nhomSanPham);
        return layHetNhomSanPham();
    }

    @Override
    public NhomSanPhamDTO layNhomSanPhamById(Long nhomSanPhamId) {
        return NhomSanPhamDTO.fromEntity(_nhomSanPhamRepo.findById(nhomSanPhamId).get());
    }

    @Override
    public FullThuocTinh layHetThuocTinh() {
        return null;
    }

    @Override
    public ChatLieuDTO layChatLieuById(Long chatLieuId) {
        return ChatLieuDTO.fromEntity(_chatLieuRepo.findById(chatLieuId).get());
    }

    @Override
    public Page<ThietKeDTO> layHetThietKe() {
        return new Page<ThietKeDTO>(ThietKeDTO.fromCollection(_thietKeRepo.findAll()), 0, 10000);
    }

    @Override
    public Page<ThietKeDTO> xoaThietKe(Long thietKeId) {
        ThietKe thietKe = _thietKeRepo.findById(thietKeId).get();
        if (_sanPhamRepository.existsByThietKe(thietKe)) {
            return null;
        }
        _thietKeRepo.deleteById(thietKeId);
        return layHetThietKe();
    }

    @Override
    public Page<ThietKeDTO> suaThietKe(ThietKe thietKe) {
        if (_thietKeRepo.existsByTenThietKeEquals(thietKe.getTenThietKe())) {
            return null;
        }
        ThietKe thietKeGoc = _thietKeRepo.findById(thietKe.getId()).get();
        thietKeGoc.setTenThietKe(thietKe.getTenThietKe());
        thietKeGoc.setNgayCapNhat(LocalDateTime.now());
        _thietKeRepo.save(thietKeGoc);
        return layHetThietKe();
    }

    @Override
    public Page<ThietKeDTO> themThietKe(ThietKe thietKe) {
        if (_thietKeRepo.existsByTenThietKeEquals(thietKe.getTenThietKe())) {
            return null;
        }
        thietKe.setNgayTao(LocalDateTime.now());
        _thietKeRepo.save(thietKe);
        thietKe.setMaThietKe("TK" + thietKe.getId());
        _thietKeRepo.save(thietKe);
        return layHetThietKe();
    }

    @Override
    public ThietKeDTO layThietKeById(Long thietKeId) {
        return ThietKeDTO.fromEntity(_thietKeRepo.findById(thietKeId).get());
    }

    @Override
    public Page<MauSacDTO> layHetMauSac() {
        return new Page<MauSacDTO>(MauSacDTO.fromCollection(_mauSacRepo.findAll()), 0, 10000);
    }

    @Override
    public Page<MauSacDTO> xoaMauSac(Long mauSacId) {
        MauSac mauSac = _mauSacRepo.findById(mauSacId).get();
        if (_sanPhamChiTietRepository.existsByMauSac(mauSac)) {
            return null;
        }
        _mauSacRepo.deleteById(mauSacId);
        return layHetMauSac();
    }

    @Override
    public Page<MauSacDTO> suaMauSac(MauSac mauSac) {
        if (_mauSacRepo.existsByTenMauEquals(mauSac.getTenMau())) {
            return null;
        }
        MauSac mauSacGoc = _mauSacRepo.findById(mauSac.getId()).get();
        mauSacGoc.setTenMau(mauSac.getTenMau());
        mauSacGoc.setNgayCapNhat(LocalDateTime.now());
        _mauSacRepo.save(mauSacGoc);
        return layHetMauSac();
    }

    @Override
    public Page<MauSacDTO> themMauSac(MauSac mauSac) {
        if (_mauSacRepo.existsByTenMauEquals(mauSac.getTenMau())) {
            return null;
        }
        mauSac.setNgayTao(LocalDateTime.now());
        _mauSacRepo.save(mauSac);
        mauSac.setMaMau("MS" + mauSac.getId());
        _mauSacRepo.save(mauSac);
        return layHetMauSac();
    }

    @Override
    public MauSacDTO layMauSacById(Long mauSacId) {
        return MauSacDTO.fromEntity(_mauSacRepo.findById(mauSacId).get());
    }

    @Override
    public Page<KichThuocDTO> layHetKichThuoc() {
        return new Page<KichThuocDTO>(KichThuocDTO.fromCollection(_kichThuocRepo.findAll()), 0, 10000);
    }

    @Override
    public Page<KichThuocDTO> xoaKichThuoc(Long kichThuocId) {
        KichThuoc kichThuoc = _kichThuocRepo.findById(kichThuocId).get();
        if (_sanPhamChiTietRepository.existsByKichThuoc(kichThuoc)) {
            return null;
        }
        _kichThuocRepo.deleteById(kichThuocId);
        return layHetKichThuoc();
    }

    @Override
    public Page<KichThuocDTO> suaKichThuoc(KichThuoc kichThuoc) {
        if (_kichThuocRepo.existsByTenKichThuocEquals(kichThuoc.getTenKichThuoc())) {
            return null;
        }
        KichThuoc kichThuocGoc = _kichThuocRepo.findById(kichThuoc.getId()).get();
        kichThuocGoc.setTenKichThuoc(kichThuoc.getTenKichThuoc());
        kichThuocGoc.setNgayCapNhat(LocalDateTime.now());
        _kichThuocRepo.save(kichThuocGoc);
        return layHetKichThuoc();
    }

    @Override
    public Page<KichThuocDTO> themKichThuoc(KichThuoc kichThuoc) {
        if (_kichThuocRepo.existsByTenKichThuocEquals(kichThuoc.getTenKichThuoc())) {
            return null;
        }
        kichThuoc.setNgayTao(LocalDateTime.now());
        _kichThuocRepo.save(kichThuoc);
        kichThuoc.setMaKichThuoc("MKT" + kichThuoc.getId());
        _kichThuocRepo.save(kichThuoc);
        return layHetKichThuoc();
    }

    @Override
    public KichThuocDTO layKichThuocById(Long kichThuocId) {
        return KichThuocDTO.fromEntity(_kichThuocRepo.findById(kichThuocId).get());
    }

    @Override
    public Page<SanPhamChiTietDTO> layHetSanPhamChiTiet() {
        return null;
    }

    @Override
    public Page<SanPhamChiTietDTO> xoaSanPhamChiTiet(Long sanPhamChiTietId) {
        return null;
    }

    @Override
    public Page<SanPhamChiTietDTO> suaSanPhamChiTiet(SanPhamChiTietRequest sanPhamChiTiet) {
        return null;
    }

    @Override
    public Page<SanPhamChiTietDTO> themSanPhamChiTiet(SanPhamChiTietRequest sanPhamChiTiet) {
        return null;
    }

    @Override
    public Page<SanPhamDTO> layHetSanPham() {
        return null;
    }

    @Override
    public SanPhamChiTietDTO laySanPhamChiTietById(Long sanPhamChiTietId) {
        return null;
    }

    @Override
    public SanPhamChiTietDTO laySanPhamChiTietByMaSp(String maSp) {
        return null;
    }

    @Override
    public Page<SanPhamChiTietDTO> laySanPhamChiTietCuaSanPham(Long sanPhamId) {
        return null;
    }

    @Override
    public ResponObject<String, APIStatus> themSanPham(SanPhamRequest sanPham, MultipartFile hinh1, MultipartFile hinh2) throws IOException {
        SanPham sanPham = new SanPham();
        sanPham.setNgayTao(LocalDateTime.now());
        sanPham.setGiaBan(sanPhamRequest.getGiaBan());
        sanPham.setSoLuongTon(0);
        sanPham.setSoLuongDaBan(0);
        sanPham.setSoLuongLoi(0);
        sanPham.setMoTa(sanPhamRequest.getMoTa());
        sanPham.setSoLuongTraHang(0);
        sanPham.setTrangThai(TrangThaiSanPham.DANGBAN);
        sanPham.setTenSanPham(sanPhamRequest.getTenSanPham());
        sanPham.setGiaNhap(sanPhamRequest.getGiaNhap());
        sanPham.setNhomSanPham(_nhomSanPhamRepo.findById(sanPhamRequest.getNhomSanPhamId()).get());
        sanPham.setChatLieu(_chatLieuRepo.findById(sanPhamRequest.getChatLieuId()).get());
        sanPham.setThietKe(_thietKeRepo.findById(sanPhamRequest.getThietKeId()).get());
        sanPham.setHinhAnh1(CloudinaryUpload.uploadFile(hinh1));
        sanPham.setHinhAnh2(CloudinaryUpload.uploadFile(hinh2));
        HinhAnhSanPham hinhAnh1 = new HinhAnhSanPham();
        hinhAnh1.setLinkHinhAnh(sanPham.getHinhAnh1());
        hinhAnh1.setSanPham(sanPham);
        hinhAnh1.setNgayTao(LocalDateTime.now());
        HinhAnhSanPham hinhAnh2 = new HinhAnhSanPham();
        hinhAnh2.setLinkHinhAnh(sanPham.getHinhAnh2());
        hinhAnh2.setSanPham(sanPham);
        hinhAnh2.setNgayTao(LocalDateTime.now());
        _sanPhamRepository.save(sanPham);
        _hinhAnhSanPhamRepo.save(hinhAnh1);
        _hinhAnhSanPhamRepo.save(hinhAnh2);
        sanPham.setMaSanPham("SP" + sanPham.getId());
        _sanPhamRepository.save(sanPham);
        return new ResponObject<String, APIStatus>("Thành công", APIStatus.THANHCONG, "Thành công");
    }

    @Override
    public SanPhamDTO laySanPhamById(Long sanPhamId) {
        return SanPhamDTO.fromEntity(_sanPhamRepository.findById(sanPhamId).get());
    }

    @Override
    public List<NhomSanPham> getAll() {
        return null;
    }

    @Override
    public Page<SanPhamDTO> capNhatSanPham(SanPhamRequest sanPhamRequest, MultipartFile multipartFile, MultipartFile multipartFile1) throws IOException {
        SanPham sp = _sanPhamRepository.findById(sanPhamRequest.getId()).get();
        if (multipartFile != null) {
            sp.setHinhAnh1(CloudinaryUpload.uploadFile(multipartFile));
            sp.setHinhAnh2(CloudinaryUpload.uploadFile(multipartFile1));
        }
        sp.setTenSanPham(sanPhamRequest.getTenSanPham());
        sp.setGiaBan(sanPhamRequest.getGiaBan());
        sp.setGiaNhap(sanPhamRequest.getGiaNhap());
        sp.setNgayCapNhat(LocalDateTime.now());
        sp.setMoTa(sanPhamRequest.getMoTa());
        sp.setTrangThai(sanPhamRequest.getTrangThai());
        sp.setThietKe(_thietKeRepo.findById(sanPhamRequest.getThietKeId()).get());
        sp.setChatLieu(_chatLieuRepo.findById(sanPhamRequest.getChatLieuId()).get());
        sp.setNhomSanPham(_nhomSanPhamRepo.findById(sanPhamRequest.getNhomSanPhamId()).get());
        _sanPhamRepository.save(sp);
        return layHetSanPham();
    }
}
