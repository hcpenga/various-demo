package com.example.variousdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: LogController
 * @description: 测试日志输出
 * 参考博客：https://blog.csdn.net/gozhuyinglong/article/details/80523756?ops_request_misc=&request_id=&biz_id=102&utm_term=springboot%E9%85%8D%E7%BD%AE%E6%97%A5%E5%BF%97%E6%96%87%E4%BB%B6&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-7-.nonecase&spm=1018.2226.3001.4187
 * @created: 2021/07/14 15:33
 */
@RestController
@RequestMapping("/log")
@Api(tags = "日志操作")
public class LogController {
    private static final Logger LOG = LoggerFactory.getLogger(LoggerFactory.class);

    /**
     * 功能描述：
     * 〈级别由低到高 trace<debug<info<warn<error〉
     * @Date: 15:36 2021/7/14 0014
     * @param
     * @return: void
     **/
    @GetMapping("/outPut")
    @ApiOperation(value = "测试日志输出")
    public void outPut(){
        //SpringBoot默认是info级别,只会输出info及以上级别的日志
        LOG.trace("输出trace日志..");
        LOG.debug("输出debug日志");
        LOG.info("输出info日志");
        LOG.warn("输出warn日志");
        LOG.error("输出error日志");
    }
}
