package com.wxq.mall.system.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wxq.common.model.ErrorCode;
import com.wxq.common.model.ResultBody;
import com.wxq.mall.utils.Constants;
import com.wxq.mall.utils.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(log.isDebugEnabled()) {
            log.info("uri: {}", request.getRequestURI());
        }

        String token = request.getHeader(Constants.TOKEN_HEADER);
        boolean pass = true;
        ResultBody resultBody = ResultBody.fail();
        if(StringUtils.isEmpty(token)){
            log.info("未携带token");
            resultBody.setCode(ErrorCode.ILLEGAL_TOKEN);
            resultBody.setMessage("未携带token");
            pass = false;
        } else {
            try{
                JwtUtil.verify(token);
            }catch (ExpiredJwtException e){
                resultBody.setCode(ErrorCode.TOKEN_EXPIRE);
                resultBody.setMessage("token过期");
                log.info("token过期");
            } catch (Exception e){
                if(!(e instanceof  ExpiredJwtException)){
                    log.error("非法token");
                }
                resultBody.setCode(ErrorCode.ILLEGAL_TOKEN);
                resultBody.setMessage("非法token");
                pass = false;
            }
        }

        if(!pass){
            String data = JSONObject.toJSONString(resultBody, SerializerFeature.WriteMapNullValue);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");

            PrintWriter writer = response.getWriter();
            writer.write(data);
            writer.close();
        }
        return pass;
    }
}
