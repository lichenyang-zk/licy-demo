package com.xxx.licy.order.client;

import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.order.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 订单客户端
 *
 * @author lichenyang
 * @since 2024/7/29 17:56
 */
@FeignClient(value = "order-server", path = "/order", fallbackFactory = OrderClient.OrderFallbackFactory.class)
public interface OrderClient {

    @PostMapping("/insert")
    ServiceResp insert(@RequestBody Order order);

    @Component
    class OrderFallbackFactory implements FallbackFactory<OrderClient> {

        private static final Logger LOGGER = LoggerFactory.getLogger(OrderFallbackFactory.class);

        @Override
        public OrderClient create(Throwable cause) {
            if (cause != null) {
                LOGGER.error("fallback exception: ", cause);
            }
            return new OrderClient() {
                @Override
                public ServiceResp insert(Order order) {
                    return ServiceResp.getServiceFallback();
                }
            };
        }
    }
}
