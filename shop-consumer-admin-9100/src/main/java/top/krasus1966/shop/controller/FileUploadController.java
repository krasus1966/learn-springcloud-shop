package top.krasus1966.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.krasus1966.fastdfs.FastDFSClient;
import top.krasus1966.shop.entity.vo.CommonResult;
import top.krasus1966.shop.enums.CommonEnum;
import top.krasus1966.shop.enums.CommonErrorEnum;
import top.krasus1966.shop.service.ResourceService;

import javax.annotation.Resource;

/**
 * @author Krasus1966
 * @date 2020/9/18 17:33
 **/
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Resource
    protected ResourceService resourceService;

    @Autowired
    private FastDFSClient fastDFSClient;

    @Value("${fastdfs.storage-server}")
    private String FASTDFS_URL;

    @PostMapping("/uploadImg")
    public CommonResult<String> uploadImg(@RequestParam("file") MultipartFile file){
        return resourceService.uploadImg(file);
    }

    @PostMapping("/imageUpload")
    public CommonResult<String> imageUpload(MultipartFile file){
        if (file.isEmpty()) {
            return CommonResult.parse(CommonEnum.INSERT_ERR);
        }
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        String extName = fileName.substring(fileName.lastIndexOf(".")).replace(".","");
        String filePathInfo;
        try {
            filePathInfo = "http://"+FASTDFS_URL+"/"+fastDFSClient.uploadFile(file.getBytes(),extName);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.parse(CommonErrorEnum.SERVICE_GOT_WRONG,e.getMessage());
        }
        return CommonResult.parse(CommonEnum.INSERT_OK,filePathInfo);
    }
}
