package top.krasus1966.shop.fallback;

import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.enums.CommonEnum;

/**
 * @author Krasus1966
 * @date 2020/7/28 21:47
 **/
public class CommonFallback {

    public CommonResult<String> handlerFallback(Throwable e){

        return CommonResult.parse(CommonEnum.FALL_BACK_ERROR,e.getMessage());
    }
}
