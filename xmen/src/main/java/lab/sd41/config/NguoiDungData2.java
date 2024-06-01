package lab.sd41.config;

import lab.sd41.entity.NguoiDung;
import lab.sd41.entity.Quyen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungData2 {
    private NguoiDung nguoiDung;
    private List<Quyen> quyenList;
}
