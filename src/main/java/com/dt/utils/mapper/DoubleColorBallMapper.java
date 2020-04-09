package com.dt.utils.mapper;

import com.dt.utils.model.DoubleColorBall;
import com.dt.utils.util.BaseMapper;

import java.util.List;

public interface DoubleColorBallMapper extends BaseMapper<DoubleColorBall> {

    void insertAllHistoryData(List<DoubleColorBall> list);
    String sss();
}