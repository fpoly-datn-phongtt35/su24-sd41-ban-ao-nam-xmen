package poly.datn.sd_41.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.datn.sd_41.entity.ChatLieu;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu,Long> {
    public boolean existsByTenChatLieuContains(String ten);
}
