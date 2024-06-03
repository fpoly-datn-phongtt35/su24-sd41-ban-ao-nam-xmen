package poly.datn.sd_41.iservice;

import poly.datn.sd_41.entity.NguoiDung;

public interface IAuthService {
    public Long dangKyTaiKhoan(NguoiDung nguoiDung);

    public Integer xacNhanTaiKhoan(String code);

    public Integer guiLaiMa(Long id);

    public Integer quenMatKhau(String email);

    public Integer doiMatKhau(String code,String matKhauMoi);
}
