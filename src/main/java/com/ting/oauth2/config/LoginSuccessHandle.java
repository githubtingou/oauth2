package com.ting.oauth2.config;

import com.alibaba.fastjson.JSON;
import com.ting.oauth2.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 登录成功处理类
 *
 * @author lishuang
 * @version 1.0
 * @date 2023/03/10 16:15
 */
@Service(value = "loginSuccessHandle")
@Slf4j
public class LoginSuccessHandle implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 登录成功处理
        try (ServletOutputStream stream = response.getOutputStream()) {
            stream.write(JSON.toJSONString(R.OK()).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("返回数据失败,", e);
        }

    }
}
