package spring.community.authentication.controller.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "회원가입 인증 API", description = "토큰 데이터를 수신받아 회원 인증을 처리합니다.")
@ApiResponses({
  @ApiResponse(responseCode = "200", description = "회원 인증 성공"),
  @ApiResponse(responseCode = "410", description = "토큰 유효기간 만료"),
  @ApiResponse(responseCode = "404", description = "잘못된 토큰 정보")
})
public @interface SignupDocs {
}