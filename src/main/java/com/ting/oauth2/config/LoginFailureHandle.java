package com.ting.oauth2.config;

import com.alibaba.fastjson.JSON;
import com.ting.oauth2.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 登录失败处理类
 *
 * @author lishuang
 * @version 1.0
 * @date 2023/03/10 16:19
 */
@Service(value = "loginFailureHandle")
@Slf4j
public class LoginFailureHandle implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        // 登录失败处理
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            outputStream.write(JSON.toJSONString(R.error(R.ResponseCode.ERROR, exception.getMessage())).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("返回数据失败,", e);
        }
    }
}
