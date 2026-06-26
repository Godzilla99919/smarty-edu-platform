package com.smartyedu.learning.controller;

import com.smartyedu.common.domain.dto.PageDTO;
import com.smartyedu.learning.domain.query.QuestionAdminPageQuery;
import com.smartyedu.learning.domain.query.ReplyPageQuery;
import com.smartyedu.learning.domain.vo.QuestionAdminVO;
import com.smartyedu.learning.domain.vo.QuestionVO;
import com.smartyedu.learning.domain.vo.ReplyVO;
import com.smartyedu.learning.service.IInteractionQuestionService;
import com.smartyedu.learning.service.IInteractionReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Api(tags = "管理端相关接口")
@RequiredArgsConstructor
public class InteractionQuestionAdminController {

    private final IInteractionReplyService replyService;

    private final IInteractionQuestionService questionService;

    @ApiOperation("分页查询问题-管理端")
    @GetMapping("/questions/page")
    public PageDTO<QuestionAdminVO> queryQuestionPageAdmin(QuestionAdminPageQuery query){
        return questionService.queryQuestionPageAdmin(query);
    }

    @ApiOperation("隐藏或显示问题-管理端")
    @PutMapping("/questions/{id}/hidden/{hidden}")
    public void hiddenQuestionAdmin(@PathVariable("id") Long id, @PathVariable("hidden") Boolean hidden){
        questionService.hiddenQuestionAdmin(id, hidden);
    }

    @ApiOperation("查询问题详情-管理端")
    @GetMapping("/questions/{id}")
    public QuestionAdminVO queryQuestionByIdAdmin(@ApiParam(value = "问题id", example = "1") @PathVariable("id") Long id){
        return questionService.queryQuestionByIdAdmin(id);
    }

    @ApiOperation("分页查询回答和评论-管理端")
    @GetMapping("/replies/page")
    public PageDTO<ReplyVO> queryReplyOrAnswerPageAdmin(ReplyPageQuery query){
        return replyService.queryReplyOrAnswerPageAdmin(query);
    }

    @ApiOperation("隐藏或显示回答和评论-管理端")
    @PutMapping("/replies/{id}/hidden/{hidden}")
    public void hiddenReplyAdmin(@PathVariable("id") Long id, @PathVariable("hidden") Boolean hidden){
        replyService.hiddenReplyAdmin(id, hidden);
    }

    @ApiOperation("查询问题详情-管理端")
    @GetMapping("/replies/{id}")
    public ReplyVO queryReplyById(@ApiParam(value = "问题id", example = "1") @PathVariable("id") Long id){
        return replyService.queryReplyById(id);
    }

}