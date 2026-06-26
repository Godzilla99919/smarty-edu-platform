package com.smartyedu.message.service;

import com.smartyedu.message.domain.dto.SmsThirdPlatformDTO;
import com.smartyedu.message.domain.dto.SmsThirdPlatformFormDTO;
import com.smartyedu.message.domain.query.SmsThirdPlatformPageQuery;
import com.smartyedu.common.domain.dto.PageDTO;
import com.smartyedu.message.domain.po.SmsThirdPlatform;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 第三方云通讯平台 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-08-19
 */
public interface ISmsThirdPlatformService extends IService<SmsThirdPlatform> {

    List<SmsThirdPlatform> queryAllPlatform();

    Long saveSmsThirdPlatform(SmsThirdPlatformFormDTO thirdPlatformDTO);

    void updateSmsThirdPlatform(SmsThirdPlatformFormDTO thirdPlatformDTO);

    PageDTO<SmsThirdPlatformDTO> querySmsThirdPlatforms(SmsThirdPlatformPageQuery query);

    SmsThirdPlatformDTO querySmsThirdPlatform(Long id);
}
