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

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SanPhamService implements ISanPhamService {
    @Autowired
    private ChatLieuRepository _chatLieuRepo;

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
        return null;
    }

    @Override
    public Page<NhomSanPhamDTO> xoaNhomSanPham(Long nhomSanPhamId) {
        return null;
    }

    @Override
    public Page<NhomSanPhamDTO> suaNhomSanPham(NhomSanPham nhomSanPham) {
        return null;
    }

    @Override
    public Page<NhomSanPhamDTO> themNhomSanPham(NhomSanPham nhomSanPham) {
        return null;
    }

    @Override
    public NhomSanPhamDTO layNhomSanPhamById(Long nhomSanPhamId) {
        return null;
    }

    @Override
    public FullThuocTinh layHetThuocTinh() {
        return null;
    }

    @Override
    public ChatLieuDTO layChatLieuById(Long chatLieuId) {
        return null;
    }

    @Override
    public Page<ThietKeDTO> layHetThietKe() {
        return null;
    }

    @Override
    public Page<ThietKeDTO> xoaThietKe(Long thietKeId) {
        return null;
    }

    @Override
    public Page<ThietKeDTO> suaThietKe(ThietKe thietKe) {
        return null;
    }

    @Override
    public Page<ThietKeDTO> themThietKe(ThietKe thietKe) {
        return null;
    }

    @Override
    public ThietKeDTO layThietKeById(Long thietKeId) {
        return null;
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
