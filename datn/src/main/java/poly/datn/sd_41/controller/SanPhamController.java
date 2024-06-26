package poly.datn.sd_41.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poly.datn.sd_41.entity.ChatLieu;
import poly.datn.sd_41.entity.NhomSanPham;
import poly.datn.sd_41.entity.ThietKe;
import poly.datn.sd_41.iservice.ISanPhamService;

@RestController
@RequestMapping("/api/sanpham")
public class SanPhamController {
    @Autowired
    private ISanPhamService _sanPhamService;

    @RequestMapping(value = "/laychatlieu", method = RequestMethod.GET)
    public ResponseEntity<?> layChatLieu() {
        return ResponseEntity.ok(_sanPhamService.layHetChatLieu());
    }

    @RequestMapping(value = "/themchatlieu", method = RequestMethod.POST)
    public ResponseEntity<?> themChatLieu(@RequestBody ChatLieu chatLieu) {
        return ResponseEntity.ok(_sanPhamService.themChatLieu(chatLieu));
    }

    @RequestMapping(value = "/xoachatlieu", method = RequestMethod.GET)
    public ResponseEntity<?> xoaChatLieu(@RequestParam Long chatLieuId) {
        return ResponseEntity.ok(_sanPhamService.xoaChatLieu(chatLieuId));
    }

    @RequestMapping(value = "/suachatlieu", method = RequestMethod.POST)
    public ResponseEntity<?> suaChatLieu(@RequestBody ChatLieu chatLieu) {
        return ResponseEntity.ok(_sanPhamService.suaChatLieu(chatLieu));
    }

    @RequestMapping(value = "/laynhomsanpham", method = RequestMethod.GET)
    public ResponseEntity<?> layNhomSp() {
        return ResponseEntity.ok(_sanPhamService.layHetNhomSanPham());
    }

    @RequestMapping(value = "/themnhomsanpham", method = RequestMethod.POST)
    public ResponseEntity<?> themNhomSanPham(@RequestBody NhomSanPham nhomSanPham) {
        return ResponseEntity.ok(_sanPhamService.themNhomSanPham(nhomSanPham));
    }

    @RequestMapping(value = "/xoanhomsanpham", method = RequestMethod.GET)
    public ResponseEntity<?> xoaNhomSanPham(@RequestParam Long nhomSanPhamId) {
        return ResponseEntity.ok(_sanPhamService.xoaNhomSanPham(nhomSanPhamId));
    }

    @RequestMapping(value = "/suanhomsanpham", method = RequestMethod.POST)
    public ResponseEntity<?> suaNhomSanPham(@RequestBody NhomSanPham nhomSanPham) {
        return ResponseEntity.ok(_sanPhamService.suaNhomSanPham(nhomSanPham));
    }

    @RequestMapping(value = "/laychatlieubyid", method = RequestMethod.GET)
    public ResponseEntity<?> laySanPhamById(@RequestParam Long chatLieuId) {
        return ResponseEntity.ok(_sanPhamService.layChatLieuById(chatLieuId));
    }

    @RequestMapping(value = "/laynhomsanphambyid", method = RequestMethod.GET)
    public ResponseEntity<?> layNhomSanPhamById(@RequestParam Long nhomSanPhamId) {
        return ResponseEntity.ok(_sanPhamService.layNhomSanPhamById(nhomSanPhamId));
    }

    @RequestMapping(value = "/laythietke", method = RequestMethod.GET)
    public ResponseEntity<?> layThietKe() {
        return ResponseEntity.ok(_sanPhamService.layHetThietKe());
    }

    @RequestMapping(value = "/themthietke", method = RequestMethod.POST)
    public ResponseEntity<?> themThietKe(@RequestBody ThietKe thietKe) {
        return ResponseEntity.ok(_sanPhamService.themThietKe(thietKe));
    }

    @RequestMapping(value = "/xoathietke", method = RequestMethod.GET)
    public ResponseEntity<?> xoaThietKe(@RequestParam Long thietKeId) {
        return ResponseEntity.ok(_sanPhamService.xoaThietKe(thietKeId));
    }

    @RequestMapping(value = "/suathietke", method = RequestMethod.POST)
    public ResponseEntity<?> suaThietKe(@RequestBody ThietKe thietKe) {
        return ResponseEntity.ok(_sanPhamService.suaThietKe(thietKe));
    }

    @RequestMapping(value = "/laythietkebyid", method = RequestMethod.GET)
    public ResponseEntity<?> layThietKeById(@RequestParam Long thietKeId) {
        return ResponseEntity.ok(_sanPhamService.layThietKeById(thietKeId));
    }

    @RequestMapping(value = "/themsanpham", method = RequestMethod.POST)
    public ResponseEntity<?> themSanPham(@RequestPart("file1") MultipartFile data1, @RequestPart("file2") MultipartFile data2, @RequestPart("data") String sanPham) throws IOException {
        Gson gson = new Gson();
        return ResponseEntity.ok(_sanPhamService.themSanPham(gson.fromJson(sanPham, SanPhamRequest.class), data1, data2));
    }

    @RequestMapping(value = "/laysanphamId", method = RequestMethod.GET)
    public ResponseEntity<?> laySanPhamBy(@RequestParam Long sanPhamId) {
        return ResponseEntity.ok(_sanPhamService.laySanPhamById(sanPhamId));
    }

    @RequestMapping(value = "/capnhatsanpham", method = RequestMethod.POST)
    public ResponseEntity<?> suaSanPham(@RequestPart("file1") Optional<MultipartFile> data1,
                                        @RequestPart("file2") Optional<MultipartFile> data2,
                                        @RequestPart("data") String sanPham) throws IOException {
        Gson gson = new Gson();
        return ResponseEntity.ok(_sanPhamService.capNhatSanPham(gson.fromJson(sanPham, SanPhamRequest.class),
                data1.isPresent() ? data1.get() : null,
                data2.isPresent() ? data2.get() : null));
    }

    @RequestMapping(value = "/laymausac", method = RequestMethod.GET)
    public ResponseEntity<?> layMauSac() {
        return ResponseEntity.ok(_sanPhamService.layHetMauSac());
    }

    @RequestMapping(value = "/themmausac", method = RequestMethod.POST)
    public ResponseEntity<?> themMauSac(@RequestBody MauSac mauSac) {
        return ResponseEntity.ok(_sanPhamService.themMauSac(mauSac));
    }

    @RequestMapping(value = "/xoamausac", method = RequestMethod.GET)
    public ResponseEntity<?> xoaMauSac(@RequestParam Long mauSacId) {
        return ResponseEntity.ok(_sanPhamService.xoaMauSac(mauSacId));
    }

    @RequestMapping(value = "/suamausac", method = RequestMethod.POST)
    public ResponseEntity<?> suaMauSac(@RequestBody MauSac mauSac) {
        return ResponseEntity.ok(_sanPhamService.suaMauSac(mauSac));
    }

    @RequestMapping(value = "/laymausacbyid", method = RequestMethod.GET)
    public ResponseEntity<?> layMauSacById(@RequestParam Long mauSacId) {
        return ResponseEntity.ok(_sanPhamService.layMauSacById(mauSacId));
    }

    @RequestMapping(value = "/laykichthuoc", method = RequestMethod.GET)
    public ResponseEntity<?> layKichThuoc() {
        return ResponseEntity.ok(_sanPhamService.layHetKichThuoc());
    }

    @RequestMapping(value = "/themkichthuoc", method = RequestMethod.POST)
    public ResponseEntity<?> themKichThuoc(@RequestBody KichThuoc kichThuoc) {
        return ResponseEntity.ok(_sanPhamService.themKichThuoc(kichThuoc));
    }

    @RequestMapping(value = "/xoakichthuoc", method = RequestMethod.GET)
    public ResponseEntity<?> xoaKichThuoc(@RequestParam Long kichThuocId) {
        return ResponseEntity.ok(_sanPhamService.xoaKichThuoc(kichThuocId));
    }

    @RequestMapping(value = "/suakichthuoc", method = RequestMethod.POST)
    public ResponseEntity<?> suaKichThuoc(@RequestBody KichThuoc kichThuoc) {
        return ResponseEntity.ok(_sanPhamService.suaKichThuoc(kichThuoc));
    }

    @RequestMapping(value = "/laykichthuocbyid", method = RequestMethod.GET)
    public ResponseEntity<?> layKichThuocById(@RequestParam Long kichThuocId) {
        return ResponseEntity.ok(_sanPhamService.layKichThuocById(kichThuocId));
    }

    @RequestMapping(value = "/themsanphamchitiet", method = RequestMethod.POST)
    public ResponseEntity<?> themSanPhamChiTiet(@RequestBody SanPhamChiTietRequest sanPhamChiTietRequest) {
        return ResponseEntity.ok(_sanPhamService.themSanPhamChiTiet(sanPhamChiTietRequest));
    }

    @RequestMapping(value = "/xoasanphamchitiet", method = RequestMethod.GET)
    public ResponseEntity<?> xoaSanPhamChiTiet(@RequestParam Long sanPhamChiTietId) {
        return ResponseEntity.ok(_sanPhamService.xoaSanPhamChiTiet(sanPhamChiTietId));
    }

    @RequestMapping(value = "/suasanphamchitiet", method = RequestMethod.POST)
    public ResponseEntity<?> suaSanPhamChiTiet(@RequestBody SanPhamChiTietRequest sanPhamChiTietRequest) {
        return ResponseEntity.ok(_sanPhamService.suaSanPhamChiTiet(sanPhamChiTietRequest));
    }
}
