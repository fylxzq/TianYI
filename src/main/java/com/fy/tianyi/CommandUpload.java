package com.fy.tianyi;

import com.alibaba.fastjson.JSONObject;
import com.ctg.ag.sdk.biz.AepDeviceCommandClient;
import com.ctg.ag.sdk.biz.aep_device_command.CreateCommandRequest;
import com.ctg.ag.sdk.biz.aep_device_command.CreateCommandResponse;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Classname CommandUpload
 * @Description TODO
 * @Date 2021/6/17 14:50
 * @Created by fy
 */

/*
* 完成指令下发的主要逻辑代码
*
* */
public class CommandUpload {


    private String masterkey;
    private int control_int;

    public CommandUpload(String masterkey, int control_int) {
        this.masterkey = masterkey;
        this.control_int = control_int;
    }
    public int uploadcommand(){
        AepDeviceCommandClient client =AepDeviceCommandClient.newClient().appKey(InputUserUtils.appkey).appSecret(InputUserUtils.appsecret).build();
        int statuscode = 0;
        try {

            CreateCommandRequest request = new CreateCommandRequest();
            request.setParamMasterKey(masterkey);
            //创建参数json对象
            JSONObject parms_json = new JSONObject();
            parms_json.put("control_int", control_int);
            //创建内容json对象
            JSONObject content_json = new JSONObject();
            content_json.put("params", parms_json);
            content_json.put("serviceIdentifier", "motor_control");
            JSONObject body_json = new JSONObject();
            //创建body json对象
            body_json.put("deviceId", InputUserUtils.deviceId);
            body_json.put("productId", Integer.parseInt(InputUserUtils.productId));
            body_json.put("operator", "fy");
            body_json.put("content", content_json);
            //body json转换成字符串，然后转成byte数组
            String body_string = body_json.toString();
            byte[] body = body_string.getBytes("utf-8");
            request.setBody(body);
            try {
                CreateCommandResponse response = client.CreateCommand(request);
                statuscode = response.getStatusCode();
                System.out.println(response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        finally {
            client.shutdown();
            return statuscode;
        }

    }
}
