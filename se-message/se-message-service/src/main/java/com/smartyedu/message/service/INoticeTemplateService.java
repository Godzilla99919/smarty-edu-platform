package com.smartyedu.message.service;

import com.smartyedu.message.domain.dto.NoticeTemplateDTO;
import com.smartyedu.message.domain.dto.NoticeTemplateFormDTO;
import com.smartyedu.message.domain.query.NoticeTemplatePageQuery;
import com.smartyedu.common.domain.dto.PageDTO;
import com.smartyedu.message.domain.po.NoticeTemplate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 通知模板 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-08-19
 */
public interface INoticeTemplateService extends IService<NoticeTemplate> {

    Long saveNoticeTemplate(NoticeTemplateFormDTO noticeTemplateFormDTO);

    void updateNoticeTemplate(NoticeTemplateFormDTO noticeTemplateFormDTO);

    PageDTO<NoticeTemplateDTO> queryNoticeTemplates(NoticeTemplatePageQuery pageQuery);

    NoticeTemplateDTO queryNoticeTemplate(Long id);

    NoticeTemplate queryByCode(String code);
}
