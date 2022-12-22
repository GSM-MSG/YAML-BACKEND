package project.gsm.yaml.domain.user.repository;

import org.springframework.data.repository.CrudRepository;
import project.gsm.yaml.domain.user.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {

    Optional<RefreshToken> findRefreshTokenByEmail(String refreshToken);
}
