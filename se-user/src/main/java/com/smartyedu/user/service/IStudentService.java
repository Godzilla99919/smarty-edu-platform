package com.smartyedu.user.service;

import com.smartyedu.common.domain.dto.PageDTO;
import com.smartyedu.user.domain.dto.StudentFormDTO;
import com.smartyedu.user.domain.query.UserPageQuery;
import com.smartyedu.user.domain.vo.StudentPageVo;

/**
 * <p>
 * 学员详情表 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-07-12
 */
public interface IStudentService {

    void saveStudent(StudentFormDTO studentFormDTO);

    void updateMyPassword(StudentFormDTO studentFormDTO);

    PageDTO<StudentPageVo> queryStudentPage(UserPageQuery pageQuery);
}
