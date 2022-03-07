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
@Operation(summary = "회원 인증여부 체크 API", description = "이메일 정보를 받아 해당 회원의 인증여부를 반환합니다.")
@ApiResponses({
  @ApiResponse(responseCode = "200", description = "인증여부 JSON 반환"),
  @ApiResponse(responseCode = "404", description = "존재하지 않는 회원")
})
public @interface CheckUserSignupVerificationDocs {
}
