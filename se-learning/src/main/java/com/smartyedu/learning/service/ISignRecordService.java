package com.smartyedu.learning.service;

import com.smartyedu.learning.domain.vo.SignResultVO;

import java.util.Deque;
import java.util.List;

public interface ISignRecordService {
    SignResultVO addSignRecords();

    Deque<Integer> querySignRecords();

}