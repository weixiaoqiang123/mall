package com.wxq.mall.system.pay;

import com.alipay.api.AlipayClient;
import com.wxq.mall.exception.BaseException;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weixiaoqiang
 * @date 2023/4/16
 **/
@Component
public class PayManager {

    @Resource
    private Map<String, PayMethod> payMethods =  new HashMap<>();

    public PayMethod getInstance(String payCode) {
        PayMethod payMethod = payMethods.get(payCode);
        if(payMethod == null){
            throw new BaseException("暂不支持此支付方式");
        }

        return payMethod;
    }
}
