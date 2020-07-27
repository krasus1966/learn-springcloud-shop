package top.krasus1966.shop.controller.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.krasus1966.shop.domain.Brand;
import top.krasus1966.shop.service.BrandService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/7/21 22:12
 **/
@Controller
public class BrandPageController {
    @Resource
    protected BrandService brandService;

    @GetMapping("/brand")
    public String brandPage(@RequestParam(value = "current",defaultValue = "1")Integer current,
                            @RequestParam(value = "size",defaultValue = "10")Integer size, ModelMap modelMap){
       Page<Brand> page =  brandService.queryPage(current,size);
       modelMap.addAttribute("page",page);
       return "admin/brand";
    }
}
