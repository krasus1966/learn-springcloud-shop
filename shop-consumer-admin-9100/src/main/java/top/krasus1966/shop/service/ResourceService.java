package top.krasus1966.shop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import top.krasus1966.shop.entity.vo.CommonResult;

/**
 * @author Krasus1966
 * @date 2020/9/18 17:34
 **/
@Component
@FeignClient(value = "shop-service-provider-resources")
@RequestMapping(value = "/provider/fileUpload")
public interface ResourceService {

    @PostMapping(value = "/imageUpload")
    CommonResult<String> uploadImg(@RequestPart("file") MultipartFile file);
}
