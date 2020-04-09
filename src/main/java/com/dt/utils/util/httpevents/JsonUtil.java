package com.dt.utils.util.httpevents;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtil {
	//日志记录
	protected static Logger log = Logger.getLogger(JsonUtil.class);

	private static final int flag = 1;
	
	
	/**
	 * ****************************************
	 * function: json字符串转实体对象(适用于单个对象的转换)
	 * @param jsonData  json字符串
	 * @param clazz  目标实体类型
	 * @return
	 * 
	 * ========================================
	 * created by Carter on 2018-10-18下午2:08:26
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	@SuppressWarnings("unchecked")
	public static <T> T JsonToObject(String jsonData,Class<T> clazz){
		try {
			Object pojo;
			JSONObject jsonObject = JSONObject.parseObject(jsonData);
			pojo = JSONObject.toJavaObject(jsonObject, clazz);
			return (T) pojo;
		} catch (Exception e) {
		    log.error("json字符串转实体对象失败", e);
		    return null;
		}
	}
	
	/**
	 * ****************************************
	 * function: json字符串转实体对象集合(适用于多个对象)
	 * @param jsonData 对象集合字符串
	 * @param clazz 对象类型
	 * @return
	 * 
	 * ========================================
	 * created by Carter on 2018-10-18下午2:27:34
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static <T>List<T> JsonToListObject(String jsonData,Class<T> clazz){
		try {
            // 解析判断返回值是否成功
			Map mapObj = JSONObject.parseObject(jsonData,Map.class);
			int flagParameter =  (int)mapObj.get("flag");
			if (flagParameter != flag){
				log.error("请求数据失败flag："+flagParameter);
				return null;
			}
			List<T> list = new ArrayList<T>();


			// 得到数据，转成list
			JSONArray jsonArray = (JSONArray)  mapObj.get("data");

			for (int i = 0; i < jsonArray.size(); i++) {
				T pojo;
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				pojo = JSONObject.toJavaObject(jsonObject, clazz);
				list.add(pojo);
			}
			return list;

		} catch (Exception e) {
		    log.error("json字符串转实体对象集合失败", e);
		    return null;
		}
	}

	public static Map<String ,Object> JsonToMap(String jsonData){
			// 解析判断返回值是否成功
			Map<String ,Object> mapObj = JSONObject.parseObject(jsonData,Map.class);
			int flagParameter =  (int)mapObj.get("flag");
			if (flagParameter != flag){
				log.error("请求数据失败flag："+flagParameter);
				return null;
			}else{
				return mapObj;
			}
	}


	public static Map<String ,Object> JsonToMapOrder (String jsonData,int OrderIndex){
		// 解析判断返回值是否成功

		Map<String ,Object> mapObj = JSONObject.parseObject(jsonData,Map.class);
		int flagParameter =  (int)mapObj.get("flag");
		if (flagParameter != flag){
			log.error("请求数据失败flag："+flagParameter);
			return null;
		}else{

			// 得到数据，转成list
			JSONArray jsonArray = (JSONArray)  mapObj.get("data");


			if (jsonArray.size() < OrderIndex){

			}

			return mapObj;
		}
	}



	/**
	 * ****************************************
	 * function: Object转json字符串
	 * @param obj 
	 * @return
	 * 
	 * ========================================
	 * created by Carter on 2018-10-18下午2:41:10
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static String ObjectToJson(Object obj){
		try {
			return JSON.toJSONString(obj);
		} catch (Exception e) {
		    log.error("实体对象转json字符串失败", e);
		    return null;
		}		
	}
	
	
	/**
	 * 空字符串处理
	 */
	private static ValueFilter filter = new ValueFilter() {
	    @Override
	    public Object process(Object obj, String s, Object v) {
	        if (v == null)
	            return "";
	        return v;
	    }
	};

	/**
	 * ****************************************
	 * function:json字符串转数组
	 * @param text
	 * @return
	 * 
	 * ========================================
	 * created by linhan on 2017年5月5日上午10:32:21
	 * description: 
	 * ========================================
	 * modified by name on time 
	 * description:
	 * 
	 * 
	 *****************************************
	 */
	public static JSONArray parseArray(String text){
        JSONArray jsonArray=JSON.parseArray(text);
        return jsonArray;
    };
        
}
