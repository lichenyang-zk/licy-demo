package com.xxx.licy.stock.client;

import com.xxx.licy.common.model.QueryReap;
import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.stock.model.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 库存客户端
 *
 * @author lichenyang
 * @since 2024/7/29 17:56
 */
@FeignClient(value = "stock-server", path = "/stock", fallbackFactory = StockClient.StockFallbackFactory.class)
public interface StockClient {

    @GetMapping("/getByProductId")
    QueryReap<Stock> getByProductId(Integer productId);

    @PostMapping("/update")
    ServiceResp update(@RequestBody Stock stock);

    @Component
    public class StockFallbackFactory implements FallbackFactory<StockClient> {

        private static final Logger LOGGER = LoggerFactory.getLogger(StockFallbackFactory.class);

        @Override
        public StockClient create(Throwable cause) {
            if (cause != null) {
                LOGGER.error("fallback exception: ", cause);
            }
            return new StockClient() {
                @Override
                public QueryReap<Stock> getByProductId(Integer productId) {
                    return QueryReap.getServiceFallback(Stock.class);
                }

                @Override
                public ServiceResp update(Stock stock) {
                    return ServiceResp.getServiceFallback();
                }
            };
        }
    }
}
