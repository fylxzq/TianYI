package com.fy.tianyi;

import com.ctg.ag.sdk.biz.AepDeviceStatusClient;
import com.ctg.ag.sdk.biz.aep_device_status.*;

import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;

import java.util.List;

/*
*
* 调用接口从平台获取数据
* */

public class DeviceStatusReciever {

	private Infomation info = new Infomation();

	public Infomation recieveStatus() throws Exception, RespondCodeException {
		//创建封装数据的对象

		//创建连接天翼平台的对象
		AepDeviceStatusClient client = null;

		try {
			//"尝试连接……"
			System.out.println(InputUserUtils.appkey);
			client = AepDeviceStatusClient.newClient().appKey(InputUserUtils.appkey).appSecret(InputUserUtils.appsecret).build();
			//如果clint!=null ,则连接到天翼平台成功
			//创建数据查询请求对象
			QueryDeviceStatusListRequest request = new QueryDeviceStatusListRequest();
			//构建请求体
			String json_string = "{\"productId\":\""+InputUserUtils.productId+"\",\"deviceId\":\"" + InputUserUtils.deviceId + "\"}";
			System.out.println(json_string);
			byte[] json_byte = json_string.getBytes("UTF-8");  // 字符串转Byte数组
			request.setBody(json_byte);

			// 接收响应内容
			QueryDeviceStatusListResponse response = client.QueryDeviceStatusList(request);
			String respond_str = response.toString();  // 发回来的JSON
			System.out.println(respond_str);
			if(response.getStatusCode()==200){
				ParsedRespond parsed_respond = RespondParser.parse(respond_str);  // JSON转Java对象
				System.out.println(parsed_respond);
				if (!parsed_respond.getCode().equals("0")) {
					//如果返回的code码是1，抛出异常
					info.setDesc(parsed_respond.getDesc());
					throw new RespondCodeException(parsed_respond.getDesc());
				} else {
					//解析返回对象并封装成Infomation对象
					List<ParsedStatus> parsed_status_list = parsed_respond.getDeviceStatusList();  // 设备状态信息表的Java对象
					info = getInfo(parsed_status_list);
				}
			}
			else{
				info.setDesc(response.getMessage());
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (RespondCodeException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			client.shutdown();
			//System.out.println("与平台的连接已断开");
		}

		return info;
	}

	/**
	 * 从ParsedStatus类中提取设备信息
	 */
	private Infomation getInfo(List<ParsedStatus> parsed_status_list) {
		long timestamp = 1L;
		float temperature = 1f;
		float  humidity = 1f;
		int size = parsed_status_list.size();
		if(size<3){
			info.setDesc("未获取到温湿度数据,请确包平台上存在温湿度数据");
		}
		for(int i=0;i<size;++i){
			String dataSetId = parsed_status_list.get(i).getDatasetId();
			if(dataSetId.equals("temperature")){
				temperature = Float.parseFloat(parsed_status_list.get(i).getValue());
			}
			if(dataSetId.equals("humidity")){
				timestamp = Long.parseLong(parsed_status_list.get(i).getTimestamp());
				humidity = Float.parseFloat(parsed_status_list.get(i).getValue());
			}
		}
		info.setUptime(timestamp);
		info.setHumidity(humidity);
		info.setTemperature(temperature);

		return info;
	}



}

