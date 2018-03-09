package com.mawenjie.MessageTraining;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.ws.http.HTTPException;

import org.apache.http.client.HttpClient;
import org.json.JSONException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

/**
 * Hello world!
 *
 */
public class App {
	// 短信应用SDK AppID
	private static final int appid = 1400071448; // 1400开头

	// 短信应用SDK AppKey
	private static final String appkey = "dccb0348c004a6bd866b330b494b8d1d";

	// 需要发送短信的手机号码
	private static final String[] phoneNumbers = { "15273202288" };

	// 短信模板ID，需要在短信应用中申请
	// 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
	private static final int templateId = 91544; // NOTE:

	// 签名
	// 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
	private static final String smsSign = "文杰工作资料"; // NOTE:

	public static void main(String[] args) throws Exception {
		try {
			ArrayList<String> params = new ArrayList<String>();
			params.add("1234");
			params.add("1");
			SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
			SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0], templateId, params, smsSign, "",
					""); // 签名参数未提供或者为空时，会使用默认签名发送短信
			System.out.print(result);
		} catch (HTTPException e) {
			// HTTP响应码错误
			e.printStackTrace();
		} catch (JSONException e) {
			// json解析错误
			e.printStackTrace();
		} catch (IOException e) {
			// 网络IO错误
			e.printStackTrace();
		}
	}
}
