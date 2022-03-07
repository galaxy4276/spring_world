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
@Operation(summary = "회원가입 API", description = "사용자의 회원가입 요청을 처리합니다.")
@ApiResponses({
  @ApiResponse(responseCode = "200", description = "회원가입 성공"),
  @ApiResponse(responseCode = "409", description = "이미 존재하는 사용자 정보 또는 이미 존재하는 회원")
})
public @interface VerifyUserDocs {}
