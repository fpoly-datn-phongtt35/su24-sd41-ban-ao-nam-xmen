package poly.datn.sd_41.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.entity.NguoiDung;
import poly.datn.sd_41.entity.Quyen;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungData2 {
    private NguoiDung nguoiDung;
    private List<Quyen> quyenList;
}