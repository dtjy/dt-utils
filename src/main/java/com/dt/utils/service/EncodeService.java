package com.dt.utils.service;

import com.dt.utils.model.UtilsEncodeDecode;

import java.util.Map;

public interface EncodeService {
    UtilsEncodeDecode encode(String code);

    void insertEncode();
    long countEncode();

    void queryBy();
}
