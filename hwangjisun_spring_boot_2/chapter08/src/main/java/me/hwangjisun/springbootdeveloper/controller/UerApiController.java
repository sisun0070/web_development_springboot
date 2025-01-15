package me.hwangjisun.springbootdeveloper.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.ahngeunsu.springbootdeveloper.dto.AddUserRequest;
import me.ahngeunsu.springbootdeveloper.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@@ -26,4 +31,19 @@ public String signup(AddUserRequest request) {
    뷰 관련 컨트롤러를 구현할겁니다
    동일 패키지에 UserViewController.java 파일을 만들겠습니다.
            */
    //로그아웃 관련
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
    /*
        /logout GET 요청을 하면 로그아웃을 담당하는 핸들러인 SecurityContextHandler의 logout()
        메서드를 호출해서 로그아웃합니다.
        templates의 articleList.html로 이동하겠습니다.
     */
}