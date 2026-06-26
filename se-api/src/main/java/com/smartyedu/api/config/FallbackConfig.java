package com.smartyedu.api.config;

import com.smartyedu.api.client.learning.fallback.LearningClientFallback;
import com.smartyedu.api.client.promotion.fallback.PromotionClientFallback;
import com.smartyedu.api.client.remark.fallback.RemarkClientFallBack;
import com.smartyedu.api.client.trade.fallback.TradeClientFallback;
import com.smartyedu.api.client.user.fallback.UserClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallbackConfig {
    @Bean
    public LearningClientFallback learningClientFallback(){
        return new LearningClientFallback();
    }

    @Bean
    public TradeClientFallback tradeClientFallback(){
        return new TradeClientFallback();
    }

    @Bean
    public UserClientFallback userClientFallback(){
        return new UserClientFallback();
    }

    @Bean
    public RemarkClientFallBack getLikedStatusByBizList(){
        return new RemarkClientFallBack();
    }

    @Bean
    public PromotionClientFallback  promotionClientFallback() {
        return new PromotionClientFallback();
    }
}
