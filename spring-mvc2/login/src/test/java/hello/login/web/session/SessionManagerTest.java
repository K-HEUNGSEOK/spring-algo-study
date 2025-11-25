package hello.login.web.session;

import static org.junit.jupiter.api.Assertions.*;

import hello.login.domain.member.Member;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class SessionManagerTest {
    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest(){
        MockHttpServletResponse response = new MockHttpServletResponse();
        //세션 생성
        Member member = new Member();
        sessionManager.createSession(member, response);

        //요청에 응답 쿠키 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies()); //request 에서 요청을 보내는 테스트 코드

        //세션 조회
        Object session = sessionManager.getSession(request);
        Assertions.assertThat(session).isEqualTo(member);

        //세션 만료
        sessionManager.expire(request);
        Object result = sessionManager.getSession(request);
        Assertions.assertThat(result).isNull();
    }
}