package top.krasus1966.shop.controller.page;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Krasus1966
 * @date 2020/8/7 21:55
 **/
@Controller
@Scope("prototype")
public class CommonController {

    /**
     * 跳转到登录页面
     * @return 登录页
     */
    @RequestMapping({"/","/admin"})
    public String loginPage(){
        return "login";
    }

    /**
     * 通用页面跳转
     * @param page 页面名称
     * @return 对应页面
     */
    @RequestMapping("/page_{page}")
    public String page(@PathVariable("page") String page){
        return "admin/"+page;
    }
}
