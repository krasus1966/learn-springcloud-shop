package top.krasus1966.shop.fallback;

import lombok.extern.slf4j.Slf4j;
import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.enums.CommonFallbackEnum;

/**
 * @author Krasus1966
 * @date 2020/7/28 21:47
 **/
@Slf4j
public class CommonFallback {
    public CommonResult<String> handlerFallback(Throwable e){
        log.error("出现熔断降级={}",e.getMessage());
        return CommonResult.parse(CommonFallbackEnum.FALL_BACK_ERROR,e.getMessage());
    }
}
