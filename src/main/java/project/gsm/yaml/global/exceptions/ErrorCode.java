package project.gsm.yaml.global.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    TOKEN_EXPIRATION("토큰이 만료 되었습니다", 401),
    TOKEN_NOT_VALID("토큰이 유효하지 않습니다", 401),
    REFRESH_TOKEN_NOT_FOUND("리프레시 토큰을 찾을 수 없습니다", 404),
    USER_NOT_FOUND("유저를 찾을 수 없습니다", 404),
    AWARDS_NOT_FOUND("수상경력을 찾을 수 없습니다", 404),
    CONTEST_NOT_FOUND("교육, 대회 참가이력을 찾을 수 없습니다", 404),
    BLACK_LIST_ALREADY_EXIST("블랙리스트에 이미 존재합니다", 409),
    BOOK_NOT_FOUND("독서활동 이력을 찾을 수 없습니다.", 404),
    VOLUNTEER_NOT_FOUND("봉사활동 이력을 찾을 수 없습니다.", 404);

    private final String message;
    private final int status;

}
