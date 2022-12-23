package project.gsm.yaml.domain.humanities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gsm.yaml.domain.humanities.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
