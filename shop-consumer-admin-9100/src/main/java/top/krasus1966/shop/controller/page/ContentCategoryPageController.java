package top.krasus1966.shop.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.krasus1966.shop.service.ContentCategoryService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/8/12 11:21
 **/
@Controller
public class ContentCategoryPageController {

    @Resource
    private ContentCategoryService contentCategoryService;

    @GetMapping("/page_content_category")
    public String contentCategoryPage(@RequestParam(value = "current",defaultValue = "1")Integer current,@RequestParam(value = "size",defaultValue = "10")Integer size, ModelMap modelMap){
        modelMap.addAttribute("pages",contentCategoryService.queryPage(current,size));
        return "admin/content_category";
    }
}
