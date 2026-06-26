package com.smartyedu.learning.controller;


import com.smartyedu.api.dto.leanring.LearningLessonDTO;
import com.smartyedu.learning.domain.dto.LearningRecordFormDTO;
import com.smartyedu.learning.service.ILearningRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 学习记录表 前端控制器
 * </p>
 *
 * @author fenny
 * @since 2023-11-21ss
 */
@Api(tags = "学习记录的相关接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/learning-records")
public class LearningRecordController {

    private final ILearningRecordService recordService;

    @ApiOperation("查询指定课程的学习记录")
    @GetMapping("/course/{courseId}")
    public LearningLessonDTO queryLearningRecordByCourse(
            @ApiParam(value = "课程id", example = "2") @PathVariable("courseId") Long courseId){
        return recordService.queryLearningRecordByCourse(courseId);
    }

    @ApiOperation("提交学习记录")
    @PostMapping()
    public void addLearningRecord(@RequestBody @Validated LearningRecordFormDTO formDTO){
        recordService.addLearningRecord(formDTO);
    }
}
