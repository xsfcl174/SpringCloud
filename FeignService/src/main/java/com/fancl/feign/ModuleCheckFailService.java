package com.fancl.feign;

import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @Description: TODO
 * @auther fanchengliang
 * @create 2017/11/6
 * @since 1.6
 */
@Component
public class ModuleCheckFailService implements ModuleCheckService {
    @Override
    public String check() {
        return "check fail";
    }
}
