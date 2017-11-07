package com.fancl.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @version 1.0.0
 * @Description: TODO
 * @auther fanchengliang
 * @create 2017/11/7
 * @since 1.6
 */
@Component
public class TokenFilter extends ZuulFilter {

    //    filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
    //    pre：路由之前
    //    routing：路由之时
    //    post： 路由之后
    //    error：发送错误调用
    //We also support a "static" type for static responses see  StaticResponseFilter.
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        final RequestContext currentContext = RequestContext.getCurrentContext();
        String auth = currentContext.getRequest().getParameter("auth");
        if (StringUtils.isEmpty(auth)) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("auth could not null");
            } catch (IOException e) {
            }
        }
        return null;
    }
}
