package top.krasus1966.shop.controller.page;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.krasus1966.shop.service.ContentCategoryService;
import top.krasus1966.shop.service.ContentService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/8/10 21:36
 **/
@Api("广告页面接口")
@Controller
public class ContentPageController {

    @Resource
    private ContentService contentService;

    @Resource
    private ContentCategoryService contentCategoryService;

    @GetMapping("/page_content")
    public String contentPage(@RequestParam(value = "current", defaultValue = "1", required = false) Integer current,
                              @RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                              ModelMap modelMap){
        modelMap.addAttribute("pages",contentService.queryPage(current,size));
        modelMap.addAttribute("contentCategorys",contentCategoryService.query());
        return "admin/content";
    }
}
