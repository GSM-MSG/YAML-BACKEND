package project.gsm.yaml.global.security.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "gauth")
public class GAuthProperties {
    private final String clientId;
    private final String clientSecret;
    private final String loginUrl;
    private final String redirectUri;
    private final String authUrl;
}
