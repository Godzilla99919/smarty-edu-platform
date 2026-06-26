package com.smartyedu.promotion.service;

import com.smartyedu.common.domain.dto.PageDTO;
import com.smartyedu.promotion.domain.dto.CouponFormDTO;
import com.smartyedu.promotion.domain.dto.CouponIssueFormDTO;
import com.smartyedu.promotion.domain.po.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smartyedu.promotion.domain.query.CouponQuery;
import com.smartyedu.promotion.domain.vo.CouponDetailVO;
import com.smartyedu.promotion.domain.vo.CouponPageVO;
import com.smartyedu.promotion.domain.vo.CouponVO;

import java.util.List;

/**
 * <p>
 * 优惠券的规则信息 服务类
 * </p>
 *
 * @author fenny
 * @since 2023-12-03
 */
public interface ICouponService extends IService<Coupon> {

    void saveCoupon(CouponFormDTO dto);

    PageDTO<CouponPageVO> queryCouponByPage(CouponQuery query);

    void updateById(CouponFormDTO dto, Long id);

    void deleteById(Long id);

    CouponDetailVO queryById(Long id);

    void beginIssue(CouponIssueFormDTO dto);

    List<CouponVO> queryIssuingCoupons();

    void pauseIssue(long id);
}
