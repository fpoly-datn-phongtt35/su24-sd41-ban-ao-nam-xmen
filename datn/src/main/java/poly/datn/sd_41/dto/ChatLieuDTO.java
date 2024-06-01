package poly.datn.sd_41.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poly.datn.sd_41.entity.ChatLieu;
import poly.datn.sd_41.entity.SanPham;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatLieuDTO  {
    private Long id;
    private String maChatLieu;
    private String tenChatLieu;
    private List<SanPham> sanPhamList;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayCapNhat;

    public static ChatLieuDTO fromEntity(ChatLieu entity) {
        return new ChatLieuDTO(
                entity.getId(),
                entity.getMaChatLieu(),
                entity.getTenChatLieu(),
                null,
                entity.getNgayTao(),
                entity.getNgayCapNhat()
        );
    }

    public static List<ChatLieuDTO> fromCollection(List<ChatLieu> collection) {
        List<ChatLieuDTO> to = new ArrayList<>();
        collection.forEach(x -> {
            to.add(fromEntity(x));
        });
        return to;
    }
}

