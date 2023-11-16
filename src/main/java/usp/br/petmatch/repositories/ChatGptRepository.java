package usp.br.petmatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usp.br.petmatch.models.ChatGptModel;

import java.util.UUID;

@Repository
public interface ChatGptRepository extends JpaRepository<ChatGptModel, UUID> {

}
