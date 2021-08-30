package com.example.variousdemo.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.variousdemo.config.JwtConfig;
import com.example.variousdemo.entity.RestResult;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @className: TokenController
 * @description:
 * @created: 2021/08/30 10:18
 */
@RestController
public class TokenController {

    @Resource
    private JwtConfig jwtConfig;

    /**
     * 功能描述：
     * 〈用户登录接口〉
     * @Date: 10:38 2021/8/30 0030
     * @param userName
     * @param passWord
     * @return: com.example.variousdemo.entity.RestResult
     **/
    @PostMapping("/login")
    public RestResult login(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord){
        JSONObject json = new JSONObject();
        // 验证userName，passWord和数据库中是否一致，如不一致，直接return ResultTool.errer(); 【这里省略该步骤】

        // 这里模拟通过用户名和密码，从数据库查询userId
        // 这里把userId转为String类型，实际开发中如果subject需要存userId，则可以JwtConfig的createToken方法的参数设置为Long类型
        String userId = "5" + "";
        String token = jwtConfig.createToken(userId);

        if(!StringUtils.isEmpty(token)){
            json.put("token",token);
        }
        return RestResult.ok(token);
    }

    /**
     * 功能描述：
     * 〈需要token验证的接口〉
     * @Date: 10:38 2021/8/30 0030
     * @param
     * @return: com.example.variousdemo.entity.RestResult
     **/
    @PostMapping("/info")
    public RestResult info(){
        return RestResult.ok("info");
    }

    /**
     * 功能描述：
     * 〈根据请求头获取到userId〉
     * @Date: 10:37 2021/8/30 0030
     * @param request
     * @return: com.example.variousdemo.entity.RestResult
     **/
    @PostMapping("/getUserInfo")
    public RestResult getUserInfo(HttpServletRequest request){
        String usernameFromToken = jwtConfig.getUsernameFromToken(request.getHeader("token"));
        return RestResult.ok(usernameFromToken);
    }

       /*
        为什么项目重启后，带着之前的token还可以访问到需要info等需要token验证的接口？
        答案：只要不过期，会一直存在，类似于redis
     */

}
