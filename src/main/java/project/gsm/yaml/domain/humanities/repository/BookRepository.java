package project.gsm.yaml.domain.humanities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.humanities.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
