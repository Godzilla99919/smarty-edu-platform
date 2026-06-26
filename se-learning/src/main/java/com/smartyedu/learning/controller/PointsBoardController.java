package com.smartyedu.learning.controller;


import com.smartyedu.common.utils.BeanUtils;
import com.smartyedu.common.utils.CollUtils;
import com.smartyedu.learning.domain.po.PointsBoardSeason;
import com.smartyedu.learning.domain.query.PointsBoardQuery;
import com.smartyedu.learning.domain.vo.PointsBoardSeasonVO;
import com.smartyedu.learning.domain.vo.PointsBoardVO;
import com.smartyedu.learning.service.IPointsBoardSeasonService;
import com.smartyedu.learning.service.IPointsBoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 学霸天梯榜 前端控制器
 * </p>
 *
 * @author fenny
 * @since 2023-11-29
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
@Api(tags = "积分相关接口")
public class PointsBoardController {

    private final IPointsBoardSeasonService seasonService;
    private final IPointsBoardService pointsBoardService;
    @ApiOperation("查询赛季信息列表")
    @GetMapping("/seasons/list")
    public List<PointsBoardSeasonVO> queryPointsBoardSeasons(){
        List<PointsBoardSeason> list = seasonService.lambdaQuery().lt(PointsBoardSeason::getBeginTime, LocalDateTime.now()).list();
        if(CollUtils.isEmpty(list)){
            return CollUtils.emptyList();
        }
        return BeanUtils.copyList(list, PointsBoardSeasonVO.class);
    }

    @GetMapping
    @ApiOperation("查询赛季积分榜")
    public PointsBoardVO queryPointsBoardBySeason(PointsBoardQuery query){
        return pointsBoardService.queryPointsBoardBySeason(query);
    }
}
