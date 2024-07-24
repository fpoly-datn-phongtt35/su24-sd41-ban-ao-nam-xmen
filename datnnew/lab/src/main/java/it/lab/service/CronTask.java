package it.lab.service;

import it.lab.iservice.Cron;
import it.lab.repository.NguoiDungVoucherRepo;
import it.lab.repository.VoucherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronTask implements Cron {

    @Autowired
    private VoucherRepo _voucherRepo;
    @Autowired
    private NguoiDungVoucherRepo _nguoiDUngVoucherRepo;

    @Scheduled(cron = "15 * * * * ?")
    @Override
    public void doiTrangThaiVoucher() {
//        var voucher = _voucherRepo.findVouchersByNgayKetThucBefore(LocalDateTime.now());
//        for (var item : voucher) {
//            if (item.getTrangThai() == TrangThaiVoucher.NGUNG) {
//                continue;
//            }
//            item.setTrangThai(TrangThaiVoucher.NGUNG);
//            var nguoiDungVoucher = _nguoiDUngVoucherRepo.findNguoiDungVouchersByVoucher(item)
//                    .stream().filter(x -> x.getTrangThai() == TrangThaiNguoiDungVoucher.SUDUNG).collect(Collectors.toList());
//            for (var ndv : nguoiDungVoucher) {
//                ndv.setTrangThai(TrangThaiNguoiDungVoucher.HETHAN);
//            }
//            _nguoiDUngVoucherRepo.saveAll(nguoiDungVoucher);
//        }
//        _voucherRepo.saveAll(voucher);
    }
}
