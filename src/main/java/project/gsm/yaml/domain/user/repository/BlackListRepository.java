package project.gsm.yaml.domain.user.repository;

import org.springframework.data.repository.CrudRepository;
import project.gsm.yaml.domain.user.entity.BlackList;

public interface BlackListRepository extends CrudRepository<BlackList, String> {
}
