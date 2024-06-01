package poly.datn.sd_41.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.dto.NguoiDungDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungData {
    private NguoiDungDTO nguoiDung;
    private String token;
    private List<String> quyenList;
}
