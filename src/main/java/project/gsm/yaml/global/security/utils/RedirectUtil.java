package project.gsm.yaml.global.security.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import project.gsm.yaml.domain.user.presentation.dto.GAuthLoginRequest;
import project.gsm.yaml.domain.user.presentation.dto.GAuthLoginResponse;
import project.gsm.yaml.domain.user.presentation.dto.UserResponse;

@RequiredArgsConstructor
public class RedirectUtil {

    private final ConfigUtils configUtils;

    public GAuthLoginResponse postCode(String code) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        GAuthLoginRequest reqParam = GAuthLoginRequest.builder()
                .code(code)
                .clientId(configUtils.getGAuthClientId())
                .clientSecret(configUtils.getGAuthClientSecret())
                .build();

        HttpEntity httpRequestEntity = new HttpEntity<>(reqParam, getHeaders());

        ResponseEntity<String> apiResponse = restTemplate.postForEntity(configUtils.getGAUthAuthUrl()+"/oauth/token", httpRequestEntity, String.class);

        ObjectMapper tokenObjectMapper = setObjectMapper();
        GAuthLoginResponse gAuthLoginResponse = tokenObjectMapper.readValue(apiResponse.getBody(), new TypeReference<GAuthLoginResponse>() {});

        return gAuthLoginResponse;
    }

    public UserResponse postToSever(String accessToken) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = getHeaders();
        headers.add("Authorization", "Bearer "+accessToken);

        HttpEntity httpRequestEntity = new HttpEntity(headers);

        ResponseEntity<String> apiResponse = restTemplate.postForEntity(configUtils.getGAUthAuthUrl()+"/user", httpRequestEntity, String.class);

        ObjectMapper userObjectMapper = setObjectMapper();
        UserResponse userResponse = userObjectMapper.readValue(apiResponse.getBody(), new TypeReference<UserResponse>() {});

        return userResponse;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ObjectMapper setObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper;
    }
}
