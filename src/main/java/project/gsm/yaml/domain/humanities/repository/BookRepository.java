package project.gsm.yaml.domain.humanities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.humanities.entity.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(Long id);
}
