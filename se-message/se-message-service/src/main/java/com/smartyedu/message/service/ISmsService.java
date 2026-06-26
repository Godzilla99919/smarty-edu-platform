package com.smartyedu.message.service;

import com.smartyedu.api.dto.sms.SmsInfoDTO;
import com.smartyedu.api.dto.user.UserDTO;
import com.smartyedu.message.domain.po.NoticeTemplate;

import java.util.List;

public interface ISmsService {
    void sendMessageByTemplate(NoticeTemplate noticeTemplate, List<UserDTO> users);

    void sendMessage(SmsInfoDTO smsInfoDTO);

    void sendMessageAsync(SmsInfoDTO smsInfoDTO);
}
