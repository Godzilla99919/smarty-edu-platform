package com.smartyedu.trade.service;

import com.smartyedu.trade.domain.dto.OrderDelayQueryDTO;
import com.smartyedu.trade.domain.dto.PayApplyFormDTO;
import com.smartyedu.trade.domain.vo.PayChannelVO;

import java.util.List;

public interface IPayService {
    List<PayChannelVO> queryPayChannels();

    String applyPayOrder(PayApplyFormDTO payApply);

    void queryPayResult(OrderDelayQueryDTO message);
}
