package hello.exception.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public @Nullable ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                                   @Nullable Object handler, Exception ex) {

        try {
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400"); //400으로 바꿀거임
                response.sendError(400, ex.getMessage());//was 엔 이렇게 들어감
                return new ModelAndView(); //뷰를 렌더링하지 않고 was 로 감 여기에 값을 지정하면 뷰를 호출한다.
            }
        }catch (IOException e){
            log.info("resolver ex ", e);
        }
        return null; //null 로 하면 예외가 계속 감 그럼 500으로 처리함
    }
}
