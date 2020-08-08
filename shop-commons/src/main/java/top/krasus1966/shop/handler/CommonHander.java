package top.krasus1966.shop.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.enums.CommonFallbackEnum;

/**
 * @author Krasus1966
 * @date 2020/7/28 21:34
 **/
@Slf4j
public class CommonHander {
    public static CommonResult<BlockException> commonHandlerException(BlockException blockException) {
        log.error("出现限流错误={}",blockException.getMessage());
        return CommonResult.parse(CommonFallbackEnum.BLOCK_EXCEPTION_ERROR);
    }
}
