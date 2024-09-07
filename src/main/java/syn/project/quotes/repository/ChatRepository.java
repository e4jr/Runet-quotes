package syn.project.quotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syn.project.quotes.models.Chat;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    Optional<Chat> findByChatIdEquals(Long chatId);

}
