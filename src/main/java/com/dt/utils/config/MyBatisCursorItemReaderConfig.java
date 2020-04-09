//package com.dt.utils.config;
//
//import com.dt.utils.model.UtilsEncodeDecode;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.batch.MyBatisCursorItemReader;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Author jiangyao
// * @Date 2019/9/1 22:24
// **/
//@Configuration
//public class MyBatisCursorItemReaderConfig {
//
//    @Bean("encodeItemReader")
//    MyBatisCursorItemReader<UtilsEncodeDecode> utilsEncodeDecodeMyBatisCursorItemReader(SqlSessionFactory sqlSessionFactory){
//        MyBatisCursorItemReader<UtilsEncodeDecode> itemReader = new MyBatisCursorItemReader<>();
//        itemReader.setQueryId("com.dt.utils.mapper.UtilsEncodeDecodeMapper");
//        itemReader.setSqlSessionFactory(sqlSessionFactory);
//        return itemReader;
//    }
//}
