package com.smartyedu.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smartyedu.api.dto.exam.QuestionDTO;
import com.smartyedu.common.domain.dto.PageDTO;
import com.smartyedu.exam.domain.dto.QuestionFormDTO;
import com.smartyedu.exam.domain.po.Question;
import com.smartyedu.exam.domain.query.QuestionPageQuery;
import com.smartyedu.exam.domain.vo.QuestionDetailVO;
import com.smartyedu.exam.domain.vo.QuestionPageVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 题目 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-09-02
 */
public interface IQuestionService extends IService<Question> {

    void addQuestion(QuestionFormDTO questionFormDTO);

    void updateQuestion(QuestionFormDTO questionDTO);

    void deleteQuestionById(Long id);

    PageDTO<QuestionPageVO> queryQuestionByPage(QuestionPageQuery query);

    QuestionDetailVO queryQuestionDetailById(Long id);

    List<QuestionDTO> queryQuestionByIds(List<Long> ids);

    Map<Long, Integer> countQuestionNumOfCreater(List<Long> createrIds);

    List<QuestionDTO> queryQuestionByBizId(Long bizId);

    Boolean checkNameValid(String name);

    Map<Long, Integer> queryQuestionScores(List<Long> ids);
}
