package com.smartyedu.learning.service;

import com.smartyedu.common.domain.dto.PageDTO;
import com.smartyedu.learning.domain.dto.QuestionFormDTO;
import com.smartyedu.learning.domain.po.InteractionQuestion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smartyedu.learning.domain.query.QuestionAdminPageQuery;
import com.smartyedu.learning.domain.query.QuestionPageQuery;
import com.smartyedu.learning.domain.vo.QuestionAdminVO;
import com.smartyedu.learning.domain.vo.QuestionVO;

/**
 * <p>
 * 互动提问的问题表 服务类
 * </p>
 *
 * @author fenny
 * @since 2023-11-24
 */
public interface IInteractionQuestionService extends IService<InteractionQuestion> {

    void saveQuestion(QuestionFormDTO questionDTO);

    void updateQuestion(Long id, QuestionFormDTO questionDTO);

    void deleteQuestion(Long id);

    PageDTO<QuestionAdminVO> queryQuestionPageAdmin(QuestionAdminPageQuery query);

    void hiddenQuestionAdmin(Long id, Boolean hidden);

    PageDTO<QuestionVO> queryQuestionPage(QuestionPageQuery query);

    QuestionVO queryQuestionById(Long id);

    QuestionAdminVO queryQuestionByIdAdmin(Long id);
}
