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

    //commit code
}
