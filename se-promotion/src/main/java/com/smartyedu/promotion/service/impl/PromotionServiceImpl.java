package com.smartyedu.promotion.service.impl;

import com.smartyedu.promotion.domain.po.Promotion;
import com.smartyedu.promotion.mapper.PromotionMapper;
import com.smartyedu.promotion.service.IPromotionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 促销活动，形式多种多样，例如：优惠券 服务实现类
 * </p>
 *
 * @author fenny
 * @since 2023-12-03
 */
@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionMapper, Promotion> implements IPromotionService {

}
