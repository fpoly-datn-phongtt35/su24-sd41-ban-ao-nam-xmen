package poly.datn.sd_41.modelcustom.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.entity.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FullThuocTinh {
    private List<MauSac> mauSacList;
    private List<NhomSanPham> nhomSanPhamList;
    private List<ChatLieu> chatLieuList;
    private List<ThietKe> thietKeList;
    private List<KichThuoc> kichThuocList;
}

