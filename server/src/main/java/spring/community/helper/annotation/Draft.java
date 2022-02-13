package spring.community.helper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @desc 현재 초안 설계만 진행 된 상태를 의미하는 어노테이션
 * void 반환 값은 대게 메서드 기능만을 이름으로 정의했음을 의미합니다.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface Draft {
  String progress();
}
