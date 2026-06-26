package com.smartyedu.learning.service;

import com.smartyedu.learning.domain.po.PointsRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smartyedu.learning.domain.vo.PointsStatisticsVO;
import com.smartyedu.learning.enums.PointsRecordType;

import java.util.List;

/**
 * <p>
 * 学习积分记录，每个月底清零 服务类
 * </p>
 *
 * @author fenny
 * @since 2023-11-29
 */
public interface IPointsRecordService extends IService<PointsRecord> {

    void addPointsRecord(Long userId, Integer points, PointsRecordType type);

    List<PointsStatisticsVO> queryMyPointsToday();

}
