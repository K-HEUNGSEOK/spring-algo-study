package hello.login.web.session;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {
    private static final String SESSION_COOKIE_NAME = "mySessionId";
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>(); //동시성문제

    public void createSession(Object value, HttpServletResponse response){
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);
        //쿠키 생성
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);
    }

    public Object getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie == null) return null;

        //성공로직의 쿠키는 (name = mySessionId, value = UUID) 를 갖고 있음
        return sessionStore.get(sessionCookie.getValue());
    }

    //세션 만료
    public void expire(HttpServletRequest request){
        Cookie cookie = findCookie(request,SESSION_COOKIE_NAME);
        if (cookie != null){
            sessionStore.remove(cookie.getValue());
        }
    }

    public Cookie findCookie(HttpServletRequest request , String cookieName){
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;

        //이렇게 하면 쿠키의 name 과 sessionName 과 비교함
       return Arrays.stream(cookies)
                .filter(c -> c.getName().equals(cookieName))
                .findFirst()
                .orElse(null);
    }
}
