package project.gsm.yaml.domain.user.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import project.gsm.yaml.domain.user.entity.User;
import project.gsm.yaml.domain.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserUtil {
    private final UserRepository userRepository;

    public User currentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUserByEmail(email).orElseThrow();
    }
}
