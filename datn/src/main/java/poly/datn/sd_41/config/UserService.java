package poly.datn.sd_41.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import poly.datn.sd_41.entity.NguoiDung;
import poly.datn.sd_41.entity.Quyen;
import poly.datn.sd_41.repository.NguoiDungRepo;
import poly.datn.sd_41.repository.QuyenRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private NguoiDungRepo _nguoiDungRepo;
    @Autowired
    private QuyenRepo _quyenRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<NguoiDung> nguoiDung = _nguoiDungRepo.findNguoiDungByEmailEquals(email.toLowerCase());
        List<Quyen> quyen = _quyenRepo.getAllQuyen(nguoiDung.get().getId());
        NguoiDungData2 nguoiDungData = new NguoiDungData2(nguoiDung.get(), quyen);
        Optional<NguoiDungData2> optCheck = Optional.of(nguoiDungData);
        return optCheck.map(NguoiDungUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Không tồn tại người dùng có email là: " + email));
    }
}
