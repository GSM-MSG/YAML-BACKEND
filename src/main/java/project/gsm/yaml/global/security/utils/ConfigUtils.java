package project.gsm.yaml.global.security.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.gsm.yaml.global.security.properties.GAuthProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConfigUtils {
    private final GAuthProperties gAuthProperties;

    public String gAuthInitUrl() {
        Map<String, Object> params = new HashMap<>();
        params.put("client_id", getGAuthClientId());
        params.put("redirect_uri", getGAuthRedirectUri());
        String paramStr = params.entrySet().stream()
                .map(param -> param.getKey() + "=" + param.getValue())
                .collect(Collectors.joining("&"));
        return getLoginUrl()
                +"/login"
                +"?"
                + paramStr;
    }

    public String getLoginUrl() {
        return gAuthProperties.getLoginUrl();
    }
    public String getGAuthClientId() {
        return gAuthProperties.getClientId();
    }

    public String getGAuthRedirectUri() {
        return gAuthProperties.getRedirectUri();
    }
}
