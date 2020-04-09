package com.dt.utils.mapper;

import com.dt.utils.model.UtilsEncodeDecode;
import com.dt.utils.util.BaseMapper;

import java.util.List;

public interface UtilsEncodeDecodeMapper extends BaseMapper<UtilsEncodeDecode> {

    String selectMinCode();

    long countCode();

    void insertListBy(List<UtilsEncodeDecode> list);

    UtilsEncodeDecode queryBy();
}