//package com.dt.utils.service.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.dt.utils.config.ApplicationContextRegister;
//import com.dt.utils.mapper.UtilsEncodeDecodeMapper;
//import com.dt.utils.model.UtilsEncodeDecode;
//import com.dt.utils.service.EncodeService;
//import com.dt.utils.util.Base64Util;
//import com.dt.utils.util.Md5Util;
//import com.dt.utils.web.EncodeController;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.batch.MyBatisCursorItemReader;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Service;
//import tk.mybatis.mapper.entity.Example;
//
//import javax.crypto.Mac;
//import java.sql.Connection;
//import java.util.*;
//
//
///**
// * @Author jiangyao
// * @Date 2019/6/27 11:00
// **/
//@Service
//public class EncodeServiceImpl implements EncodeService {
//
//    private final static Logger LOGGER = LoggerFactory.getLogger(EncodeServiceImpl.class);
//
//    @Autowired
//    UtilsEncodeDecodeMapper encodeDecodeMapper;
//
//    @Value("${num}")
//    String num;
////    @Autowired
////    private ApplicationContext applicationContext;
//    @Autowired
//    SqlSessionFactory sqlSessionFactory;
//
//    @Autowired
//    MyBatisCursorItemReader<UtilsEncodeDecode> encodeItemReader;
//
//
//    @Override
//    public UtilsEncodeDecode encode(String code) {
//        //查询是否存在
//        Example encodeExample = new Example(UtilsEncodeDecode.class);
//        encodeExample.createCriteria().andEqualTo("code",code);
//        UtilsEncodeDecode encode = this.encodeDecodeMapper.selectOneByExample(encodeExample);
//        if (null != encode){
//            return encode;
//        }
//        encode = new UtilsEncodeDecode();
//        encode.setCode(code);
//        encode.setBase64(Base64Util.encode(code));
//        encode.setBase64Base64(Base64Util.encode(Base64Util.encode(code)));
//        encode.setBase64Md5(Base64Util.encode(Md5Util.encode(code)));
//        encode.setMd5(Md5Util.encode(code));
//        encode.setMd5Md5(Md5Util.encode(Md5Util.encode(code)));
//        encode.setMd5Md5Md5(Md5Util.encode(Md5Util.encode(Md5Util.encode(code))));
//        encode.setMd5Base64(Md5Util.encode(code));
//        this.encodeDecodeMapper.insertSelective(encode);
//        return encode;
//    }
//
//    @Override
//    public void queryBy() {
//        try {
//            Map<String, Object> param = new HashMap<>();
//
//
//
//
//
//            // 设置参数
//            encodeItemReader.setParameterValues(param);
//            encodeItemReader.
//            // 创建游标
////            encodeItemReader.
//
//            //使用游标迭代获取每个记录
//            Long count = 0L;
//            UtilsEncodeDecode utilsEncodeDecode;
//            while ((utilsEncodeDecode = encodeItemReader.read()) != null) {
//
//                System.out.println(JSON.toJSONString(utilsEncodeDecode));
//                System.out.println(count);
//
//            }
//        } catch (Exception e) {
//            System.out.println("error:" + e.getLocalizedMessage());
//        } finally {
//
//            // do some
////            encodeItemReader.
//        }
//        encodeDecodeMapper.queryBy();
//    }
//
//    @Override
//    public long countEncode() {
//        return encodeDecodeMapper.countCode();
//    }
//
//    /**
//     * 99999999
//     */
//    @Override
//    public void insertEncode(){
//        String min = encodeDecodeMapper.selectMinCode();
//
//        MyThread thread = new MyThread(this.encodeDecodeMapper,Long.parseLong(min)-1);
//        thread.start();
//    }
//
//    class MyThread extends Thread{
//        UtilsEncodeDecodeMapper encodeDecodeMapper;
//        long num;
//        MyThread(){
//
//        }
//        MyThread(UtilsEncodeDecodeMapper encodeDecodeMapper,long num){
//            this.encodeDecodeMapper = encodeDecodeMapper;
//            this.num = num;
//        }
//        public UtilsEncodeDecodeMapper getEncodeDecodeMapper() {
//            return encodeDecodeMapper;
//        }
//
//        public void setEncodeDecodeMapper(UtilsEncodeDecodeMapper encodeDecodeMapper) {
//            this.encodeDecodeMapper = encodeDecodeMapper;
//
//        }
//
//        public long getNum() {
//            return num;
//        }
//
//        public void setNum(long num) {
//            this.num = num;
//        }
//
//        @Override
//        public void run() {
//            List<UtilsEncodeDecode> list = new ArrayList<>();
//            long d = this.num;
//            UtilsEncodeDecode encode = null;
//
//
//            for (long i=d,j=0; i>=0; i--,j++){
//                if (i>=10000000){
//                    String code = i+"";
//                    encode = new UtilsEncodeDecode();
//                    encode.setCode(code);
//                    encode.setBase64(Base64Util.encode(code));
//                    encode.setBase64Base64(Base64Util.encode(Base64Util.encode(code)));
//                    encode.setBase64Md5(Base64Util.encode(Md5Util.encode(code)));
//                    encode.setMd5(Md5Util.encode(code));
//                    encode.setMd5Md5(Md5Util.encode(Md5Util.encode(code)));
//                    encode.setMd5Md5Md5(Md5Util.encode(Md5Util.encode(Md5Util.encode(code))));
//                    encode.setMd5Base64(Md5Util.encode(code));
//                    encode.setCreateTime(new Date());
//                    list.add(encode);
//
//                }
//                else if (i<10000000 && i>=1000000){
//                    String code = "0"+i+"";
//                    encode = new UtilsEncodeDecode();
//                    encode.setCode(code);
//                    encode.setBase64(Base64Util.encode(code));
//                    encode.setBase64Base64(Base64Util.encode(Base64Util.encode(code)));
//                    encode.setBase64Md5(Base64Util.encode(Md5Util.encode(code)));
//                    encode.setMd5(Md5Util.encode(code));
//                    encode.setMd5Md5(Md5Util.encode(Md5Util.encode(code)));
//                    encode.setMd5Md5Md5(Md5Util.encode(Md5Util.encode(Md5Util.encode(code))));
//                    encode.setMd5Base64(Md5Util.encode(code));
//                    encode.setCreateTime(new Date());
//                    list.add(encode);
//                }
//                else if (i<1000000 && i>=100000){
//                    String code = "00"+i+"";
//                    encode = new UtilsEncodeDecode();
//                    encode.setCode(code);
//                    encode.setBase64(Base64Util.encode(code));
//                    encode.setBase64Base64(Base64Util.encode(Base64Util.encode(code)));
//                    encode.setBase64Md5(Base64Util.encode(Md5Util.encode(code)));
//                    encode.setMd5(Md5Util.encode(code));
//                    encode.setMd5Md5(Md5Util.encode(Md5Util.encode(code)));
//                    encode.setMd5Md5Md5(Md5Util.encode(Md5Util.encode(Md5Util.encode(code))));
//                    encode.setMd5Base64(Md5Util.encode(code));
//                    encode.setCreateTime(new Date());
//                    list.add(encode);
//                }
//                else if (i<100000 && i>=10000){
//                    String code = "000"+i+"";
//                    encode = new UtilsEncodeDecode();
//                    encode.setCode(code);
//                    encode.setBase64(Base64Util.encode(code));
//                    encode.setBase64Base64(Base64Util.encode(Base64Util.encode(code)));
//                    encode.setBase64Md5(Base64Util.encode(Md5Util.encode(code)));
//                    encode.setMd5(Md5Util.encode(code));
//                    encode.setMd5Md5(Md5Util.encode(Md5Util.encode(code)));
//                    encode.setMd5Md5Md5(Md5Util.encode(Md5Util.encode(Md5Util.encode(code))));
//                    encode.setMd5Base64(Md5Util.encode(code));
//                    encode.setCreateTime(new Date());
//                    list.add(encode);
//                }
//                else if (i<10000 && i>=1000){
//                    String code = "0000"+i+"";
//                    encode = new UtilsEncodeDecode();
//                    encode.setCode(code);
//                    encode.setBase64(Base64Util.encode(code));
//                    encode.setBase64Base64(Base64Util.encode(Base64Util.encode(code)));
//                    encode.setBase64Md5(Base64Util.encode(Md5Util.encode(code)));
//                    encode.setMd5(Md5Util.encode(code));
//                    encode.setMd5Md5(Md5Util.encode(Md5Util.encode(code)));
//                    encode.setMd5Md5Md5(Md5Util.encode(Md5Util.encode(Md5Util.encode(code))));
//                    encode.setMd5Base64(Md5Util.encode(code));
//                    encode.setCreateTime(new Date());
//                    list.add(encode);
//                }
//                else if (i<1000 && i>=100){
//                    String code = "00000"+i+"";
//                    encode = new UtilsEncodeDecode();
//                    encode.setCode(code);
//                    encode.setBase64(Base64Util.encode(code));
//                    encode.setBase64Base64(Base64Util.encode(Base64Util.encode(code)));
//                    encode.setBase64Md5(Base64Util.encode(Md5Util.encode(code)));
//                    encode.setMd5(Md5Util.encode(code));
//                    encode.setMd5Md5(Md5Util.encode(Md5Util.encode(code)));
//                    encode.setMd5Md5Md5(Md5Util.encode(Md5Util.encode(Md5Util.encode(code))));
//                    encode.setMd5Base64(Md5Util.encode(code));
//                    encode.setCreateTime(new Date());
//                    list.add(encode);
//                }
//                else if (i<100 && i>=10){
//                    String code = "000000"+i+"";
//                    encode = new UtilsEncodeDecode();
//                    encode.setCode(code);
//                    encode.setBase64(Base64Util.encode(code));
//                    encode.setBase64Base64(Base64Util.encode(Base64Util.encode(code)));
//                    encode.setBase64Md5(Base64Util.encode(Md5Util.encode(code)));
//                    encode.setMd5(Md5Util.encode(code));
//                    encode.setMd5Md5(Md5Util.encode(Md5Util.encode(code)));
//                    encode.setMd5Md5Md5(Md5Util.encode(Md5Util.encode(Md5Util.encode(code))));
//                    encode.setMd5Base64(Md5Util.encode(code));
//                    encode.setCreateTime(new Date());
//                    list.add(encode);
//                }
//                else if (i<10 && i>=0){
//                    String code = "0000000"+i+"";
//                    encode = new UtilsEncodeDecode();
//                    encode.setCode(code);
//                    encode.setBase64(Base64Util.encode(code));
//                    encode.setBase64Base64(Base64Util.encode(Base64Util.encode(code)));
//                    encode.setBase64Md5(Base64Util.encode(Md5Util.encode(code)));
//                    encode.setMd5(Md5Util.encode(code));
//                    encode.setMd5Md5(Md5Util.encode(Md5Util.encode(code)));
//                    encode.setMd5Md5Md5(Md5Util.encode(Md5Util.encode(Md5Util.encode(code))));
//                    encode.setMd5Base64(Md5Util.encode(code));
//                    encode.setCreateTime(new Date());
//                    list.add(encode);
//                }
//                if (j==100){
//                    this.encodeDecodeMapper.insertListBy(list);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        LOGGER.error("sleep线程异常",e);
//                    }
//                    list.clear();
//                    j=0;
//                }
//            }
//        }
//    }
//
//}
