package com.smartyedu.api.client.remark;

import com.smartyedu.api.client.remark.fallback.RemarkClientFallBack;
import com.smartyedu.common.domain.dto.LikeRecordFormDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(value = "remark-service", fallbackFactory = RemarkClientFallBack.class)
public interface RemarkClient {

    @GetMapping("/likes/list")
    Set<Long> getLikedStatusByBizList(@RequestParam("bizIds") Iterable<Long> bizIds);

    @PostMapping("/likes")
    public void addLikeRecord(@RequestBody @Validated LikeRecordFormDTO dto);

}