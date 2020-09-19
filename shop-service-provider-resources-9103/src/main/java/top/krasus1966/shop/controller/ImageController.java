package top.krasus1966.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.krasus1966.fastdfs.FastDFSClient;
import top.krasus1966.shop.entity.vo.CommonResult;
import top.krasus1966.shop.enums.CommonEnum;
import top.krasus1966.shop.exception.CommonErrorCode;

/**
 * @author Krasus1966
 * @date 2020/9/18 15:32
 **/
@RestController
@Scope("prototype")
@RequestMapping("/provider/fileUpload")
public class ImageController {

    @Autowired
    private FastDFSClient fastDFSClient;

    @PostMapping("/imageUpload")
    public CommonResult<String> imageUpload(MultipartFile file) {
        if (file.isEmpty()) {
            return CommonResult.parse(CommonEnum.INSERT_ERR);
        }
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        String extName = fileName.substring(fileName.lastIndexOf(".")).replace(".","");
        String filePathInfo;
        try {
            filePathInfo = fastDFSClient.uploadFile(file.getBytes(),extName);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.parse(CommonErrorCode.SERVICE_GOT_WRONG,e.getMessage());
        }
        return CommonResult.parse(CommonEnum.INSERT_OK,filePathInfo);
    }

//    @PostMapping("/imageDownload")
//    public CommonResult<String> imageDownload(@RequestParam("filePath")String filePath){
//        if (filePath.isEmpty()) {
//            return CommonResult.parse(CommonEnum.INSERT_ERR);
//        }
//        try {
//            fastDFSClient.download(filePath,);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return CommonResult.parse(CustomizeErrorCode.SERVICE_GOT_WRONG,e.getMessage());
//        }
//        return CommonResult.parse(CommonEnum.INSERT_OK,filePathInfo);
//    }
}
