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
        return null;
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
        return null;
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
        return null;
    }

    @Override
    public Page<MauSacDTO> xoaMauSac(Long mauSacId) {
        return null;
    }

    @Override
    public Page<MauSacDTO> suaMauSac(MauSac mauSac) {
        return null;
    }

    @Override
    public Page<MauSacDTO> themMauSac(MauSac mauSac) {
        return null;
    }

    @Override
    public MauSacDTO layMauSacById(Long mauSacId) {
        return null;
    }

    @Override
    public Page<KichThuocDTO> layHetKichThuoc() {
        return null;
    }

    @Override
    public Page<KichThuocDTO> xoaKichThuoc(Long kichThuocId) {
        return null;
    }

    @Override
    public Page<KichThuocDTO> suaKichThuoc(KichThuoc kichThuoc) {
        return null;
    }

    @Override
    public Page<KichThuocDTO> themKichThuoc(KichThuoc kichThuoc) {
        return null;
    }

    @Override
    public KichThuocDTO layKichThuocById(Long kichThuocId) {
        return null;
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
        return null;
    }

    @Override
    public SanPhamDTO laySanPhamById(Long sanPhamId) {
        return null;
    }

    @Override
    public List<NhomSanPham> getAll() {
        return null;
    }

    @Override
    public Page<SanPhamDTO> capNhatSanPham(SanPhamRequest sanPhamRequest, MultipartFile multipartFile, MultipartFile multipartFile1) throws IOException {
        return null;
    }
}
