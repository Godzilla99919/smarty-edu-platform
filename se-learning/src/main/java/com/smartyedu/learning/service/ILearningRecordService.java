package com.smartyedu.learning.service;

import com.smartyedu.api.dto.leanring.LearningLessonDTO;
import com.smartyedu.learning.domain.dto.LearningRecordFormDTO;
import com.smartyedu.learning.domain.po.LearningRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 学习记录表 服务类
 * </p>
 *
 * @author fenny
 * @since 2023-11-21
 */
public interface ILearningRecordService extends IService<LearningRecord> {

    LearningLessonDTO queryLearningRecordByCourse(Long courseId);

    void addLearningRecord(LearningRecordFormDTO formDTO);
}
