package lab.sd41.config;

import lab.sd41.dto.NguoiDungDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
