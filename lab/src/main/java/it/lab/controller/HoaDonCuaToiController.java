package it.lab.controller;

import it.lab.dto.DiaChiDTO;
import it.lab.iservice.IHoaDonNguoiDungService;
import it.lab.iservice.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nguoi_dung")
public class HoaDonCuaToiController {
    @Autowired
    private IHoaDonNguoiDungService _hoaDonNguoiDungService;

    @Autowired
    private IHoaDonService _hoaDonService;

    @RequestMapping(value = "/layhoadon", method = RequestMethod.GET)
    public ResponseEntity<?> layHoaDon(
            @RequestParam Long nguoiDungId,
            @RequestParam Integer type
    ) {
        return ResponseEntity.ok(_hoaDonNguoiDungService.layHoaDonNguoiDung(
                nguoiDungId,
                type
        ));
    }

    @RequestMapping(value = "/taodiachi", method = RequestMethod.POST)
    public ResponseEntity<?> thayDoiPhiVanChuyen(@RequestBody DiaChiDTO diaChi) {
        _hoaDonService.taoDiaChi(diaChi);
        return ResponseEntity.ok("");
    }
}
