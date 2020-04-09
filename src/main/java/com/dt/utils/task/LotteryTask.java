package com.dt.utils.task;

import com.dt.utils.mapper.DoubleColorBallMapper;
import com.dt.utils.model.DoubleColorBall;
import lombok.extern.slf4j.Slf4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author jiangyao
 * @Date 2019/10/26 0:00
 **/
//@Component
@Slf4j
public class LotteryTask {

    @Autowired
    DoubleColorBallMapper doubleColorBallMapper;

    //    @Scheduled(cron = "${dcb.history.task}")
    @Scheduled(cron = "0 0/1 * * * ?")
    public void doTask()throws Exception{
        log.info("项目启动，数据采集页面爬取任务开始");
        Integer year = LocalDate.now().getYear();
        List<DoubleColorBall> list = null;
        for(int i=2003;i<=year;i++) {
            list = queryHistoryData(year);
            log.info(doubleColorBallMapper.sss());
//            doubleColorBallMapper.insertAllHistoryData(list);
        }
        log.info("项目启动，数据采集页面爬取任务结束");
    }

    public List<DoubleColorBall> queryHistoryData(Integer year) throws Exception{
        DoubleColorBall ball = null;
        Elements tds = null;
        List<DoubleColorBall> list = new ArrayList<>();
        Document doc = Jsoup.connect("https://kjh.55128.cn/ssq-history-"+year+".htm").get();
        Element tbody = doc.getElementsByTag("tbody").first();
        Elements trs = tbody.getElementsByTag("tr");
        for(int j=2;j<trs.size();j++) {
            tds = trs.get(j).getElementsByTag("td");
            ball = new DoubleColorBall(tds.get(1).text(),tds.get(3).text(),tds.get(0).text());
            list.add(ball);
        }
        Thread.sleep(500);
        return list;
    }
}
