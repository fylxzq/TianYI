

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Future;

import org.junit.Test;

import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;

import com.ctg.ag.sdk.biz.AepRuleEngineClient;
import com.ctg.ag.sdk.biz.aep_rule_engine.SaasCreateRuleRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.SaasCreateRuleResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.SaasQueryRuleRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.SaasQueryRuleResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.SaasUpdateRuleRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.SaasUpdateRuleResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.SaasDeleteRuleEngineRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.SaasDeleteRuleEngineResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.CreateRuleRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.CreateRuleResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.UpdateRuleRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.UpdateRuleResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.DeleteRuleRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.DeleteRuleResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.GetRulesRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.GetRulesResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.GetRuleRunStatusRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.GetRuleRunStatusResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.UpdateRuleRunStatusRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.UpdateRuleRunStatusResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.CreateForwardRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.CreateForwardResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.UpdateForwardRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.UpdateForwardResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.DeleteForwardRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.DeleteForwardResponse;
import com.ctg.ag.sdk.biz.aep_rule_engine.GetForwardsRequest;
import com.ctg.ag.sdk.biz.aep_rule_engine.GetForwardsResponse;


public class AepRuleEngineDemo {

	// 没有签名同步调用接口示例
	@Test
	public void testApi() throws Exception {

		AepRuleEngineClient client = AepRuleEngineClient.newClient().build();

		{
			SaasCreateRuleRequest request = new SaasCreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasCreateRule(request));
		}
		
		{
			SaasQueryRuleRequest request = new SaasQueryRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasQueryRule(request));
		}
		
		{
			SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasUpdateRule(request));
		}
		
		{
			SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasDeleteRuleEngine(request));
		}
		
		{
			CreateRuleRequest request = new CreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateRule(request));
		}
		
		{
			UpdateRuleRequest request = new UpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateRule(request));
		}
		
		{
			DeleteRuleRequest request = new DeleteRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteRule(request));
		}
		
		{
			GetRulesRequest request = new GetRulesRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetRules(request));
		}
		
		{
			GetRuleRunStatusRequest request = new GetRuleRunStatusRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetRuleRunStatus(request));
		}
		
		{
			UpdateRuleRunStatusRequest request = new UpdateRuleRunStatusRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateRuleRunStatus(request));
		}
		
		{
			CreateForwardRequest request = new CreateForwardRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateForward(request));
		}
		
		{
			UpdateForwardRequest request = new UpdateForwardRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateForward(request));
		}
		
		{
			DeleteForwardRequest request = new DeleteForwardRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteForward(request));
		}
		
		{
			GetForwardsRequest request = new GetForwardsRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetForwards(request));
		}
		
		client.shutdown();

	}

	// 没有签名异步调用接口示例
	@Test
	public void testApiAsync() throws Exception {

		AepRuleEngineClient client = AepRuleEngineClient.newClient().build();

		{
			
			List<Future<SaasCreateRuleResponse>> res = new ArrayList<Future<SaasCreateRuleResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				SaasCreateRuleRequest request = new SaasCreateRuleRequest();
				// request.setParam..  	// set your request params here

				res.add(client.saasCreateRule(request, new ApiCallBack<SaasCreateRuleRequest, SaasCreateRuleResponse>() {
					@Override
					public void onFailure(SaasCreateRuleRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(SaasCreateRuleRequest request, SaasCreateRuleResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<SaasCreateRuleResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<SaasQueryRuleResponse>> res = new ArrayList<Future<SaasQueryRuleResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				SaasQueryRuleRequest request = new SaasQueryRuleRequest();
				// request.setParam..  	// set your request params here

				res.add(client.saasQueryRule(request, new ApiCallBack<SaasQueryRuleRequest, SaasQueryRuleResponse>() {
					@Override
					public void onFailure(SaasQueryRuleRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(SaasQueryRuleRequest request, SaasQueryRuleResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<SaasQueryRuleResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<SaasUpdateRuleResponse>> res = new ArrayList<Future<SaasUpdateRuleResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
				// request.setParam..  	// set your request params here

				res.add(client.saasUpdateRule(request, new ApiCallBack<SaasUpdateRuleRequest, SaasUpdateRuleResponse>() {
					@Override
					public void onFailure(SaasUpdateRuleRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(SaasUpdateRuleRequest request, SaasUpdateRuleResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<SaasUpdateRuleResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<SaasDeleteRuleEngineResponse>> res = new ArrayList<Future<SaasDeleteRuleEngineResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
				// request.setParam..  	// set your request params here

				res.add(client.saasDeleteRuleEngine(request, new ApiCallBack<SaasDeleteRuleEngineRequest, SaasDeleteRuleEngineResponse>() {
					@Override
					public void onFailure(SaasDeleteRuleEngineRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(SaasDeleteRuleEngineRequest request, SaasDeleteRuleEngineResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<SaasDeleteRuleEngineResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<CreateRuleResponse>> res = new ArrayList<Future<CreateRuleResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CreateRuleRequest request = new CreateRuleRequest();
				// request.setParam..  	// set your request params here

				res.add(client.CreateRule(request, new ApiCallBack<CreateRuleRequest, CreateRuleResponse>() {
					@Override
					public void onFailure(CreateRuleRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CreateRuleRequest request, CreateRuleResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CreateRuleResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<UpdateRuleResponse>> res = new ArrayList<Future<UpdateRuleResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				UpdateRuleRequest request = new UpdateRuleRequest();
				// request.setParam..  	// set your request params here

				res.add(client.UpdateRule(request, new ApiCallBack<UpdateRuleRequest, UpdateRuleResponse>() {
					@Override
					public void onFailure(UpdateRuleRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(UpdateRuleRequest request, UpdateRuleResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<UpdateRuleResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<DeleteRuleResponse>> res = new ArrayList<Future<DeleteRuleResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				DeleteRuleRequest request = new DeleteRuleRequest();
				// request.setParam..  	// set your request params here

				res.add(client.DeleteRule(request, new ApiCallBack<DeleteRuleRequest, DeleteRuleResponse>() {
					@Override
					public void onFailure(DeleteRuleRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(DeleteRuleRequest request, DeleteRuleResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<DeleteRuleResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<GetRulesResponse>> res = new ArrayList<Future<GetRulesResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				GetRulesRequest request = new GetRulesRequest();
				// request.setParam..  	// set your request params here

				res.add(client.GetRules(request, new ApiCallBack<GetRulesRequest, GetRulesResponse>() {
					@Override
					public void onFailure(GetRulesRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(GetRulesRequest request, GetRulesResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<GetRulesResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<GetRuleRunStatusResponse>> res = new ArrayList<Future<GetRuleRunStatusResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				GetRuleRunStatusRequest request = new GetRuleRunStatusRequest();
				// request.setParam..  	// set your request params here

				res.add(client.GetRuleRunStatus(request, new ApiCallBack<GetRuleRunStatusRequest, GetRuleRunStatusResponse>() {
					@Override
					public void onFailure(GetRuleRunStatusRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(GetRuleRunStatusRequest request, GetRuleRunStatusResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<GetRuleRunStatusResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<UpdateRuleRunStatusResponse>> res = new ArrayList<Future<UpdateRuleRunStatusResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				UpdateRuleRunStatusRequest request = new UpdateRuleRunStatusRequest();
				// request.setParam..  	// set your request params here

				res.add(client.UpdateRuleRunStatus(request, new ApiCallBack<UpdateRuleRunStatusRequest, UpdateRuleRunStatusResponse>() {
					@Override
					public void onFailure(UpdateRuleRunStatusRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(UpdateRuleRunStatusRequest request, UpdateRuleRunStatusResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<UpdateRuleRunStatusResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<CreateForwardResponse>> res = new ArrayList<Future<CreateForwardResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CreateForwardRequest request = new CreateForwardRequest();
				// request.setParam..  	// set your request params here

				res.add(client.CreateForward(request, new ApiCallBack<CreateForwardRequest, CreateForwardResponse>() {
					@Override
					public void onFailure(CreateForwardRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CreateForwardRequest request, CreateForwardResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CreateForwardResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<UpdateForwardResponse>> res = new ArrayList<Future<UpdateForwardResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				UpdateForwardRequest request = new UpdateForwardRequest();
				// request.setParam..  	// set your request params here

				res.add(client.UpdateForward(request, new ApiCallBack<UpdateForwardRequest, UpdateForwardResponse>() {
					@Override
					public void onFailure(UpdateForwardRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(UpdateForwardRequest request, UpdateForwardResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<UpdateForwardResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<DeleteForwardResponse>> res = new ArrayList<Future<DeleteForwardResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				DeleteForwardRequest request = new DeleteForwardRequest();
				// request.setParam..  	// set your request params here

				res.add(client.DeleteForward(request, new ApiCallBack<DeleteForwardRequest, DeleteForwardResponse>() {
					@Override
					public void onFailure(DeleteForwardRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(DeleteForwardRequest request, DeleteForwardResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<DeleteForwardResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<GetForwardsResponse>> res = new ArrayList<Future<GetForwardsResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				GetForwardsRequest request = new GetForwardsRequest();
				// request.setParam..  	// set your request params here

				res.add(client.GetForwards(request, new ApiCallBack<GetForwardsRequest, GetForwardsResponse>() {
					@Override
					public void onFailure(GetForwardsRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(GetForwardsRequest request, GetForwardsResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<GetForwardsResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	// 没有签名https同步调用接口示例
	@Test
	public void testApiWithSsl() throws Exception {

		AepRuleEngineClient client = AepRuleEngineClient.newClient().scheme(Scheme.HTTPS).build();

		{
			SaasCreateRuleRequest request = new SaasCreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasCreateRule(request));
		}
		
		{
			SaasQueryRuleRequest request = new SaasQueryRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasQueryRule(request));
		}
		
		{
			SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasUpdateRule(request));
		}
		
		{
			SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasDeleteRuleEngine(request));
		}
		
		{
			CreateRuleRequest request = new CreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateRule(request));
		}
		
		{
			UpdateRuleRequest request = new UpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateRule(request));
		}
		
		{
			DeleteRuleRequest request = new DeleteRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteRule(request));
		}
		
		{
			GetRulesRequest request = new GetRulesRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetRules(request));
		}
		
		{
			GetRuleRunStatusRequest request = new GetRuleRunStatusRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetRuleRunStatus(request));
		}
		
		{
			UpdateRuleRunStatusRequest request = new UpdateRuleRunStatusRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateRuleRunStatus(request));
		}
		
		{
			CreateForwardRequest request = new CreateForwardRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateForward(request));
		}
		
		{
			UpdateForwardRequest request = new UpdateForwardRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateForward(request));
		}
		
		{
			DeleteForwardRequest request = new DeleteForwardRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteForward(request));
		}
		
		{
			GetForwardsRequest request = new GetForwardsRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetForwards(request));
		}
		
		client.shutdown();
	}

	// 签名同步调用接口示例
	@Test
	public void testApiWithSignature() throws Exception {

		AepRuleEngineClient client = AepRuleEngineClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			SaasCreateRuleRequest request = new SaasCreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasCreateRule(request));
		}
		
		{
			SaasQueryRuleRequest request = new SaasQueryRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasQueryRule(request));
		}
		
		{
			SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasUpdateRule(request));
		}
		
		{
			SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasDeleteRuleEngine(request));
		}
		
		{
			CreateRuleRequest request = new CreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateRule(request));
		}
		
		{
			UpdateRuleRequest request = new UpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateRule(request));
		}
		
		{
			DeleteRuleRequest request = new DeleteRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteRule(request));
		}
		
		{
			GetRulesRequest request = new GetRulesRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetRules(request));
		}
		
		{
			GetRuleRunStatusRequest request = new GetRuleRunStatusRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetRuleRunStatus(request));
		}
		
		{
			UpdateRuleRunStatusRequest request = new UpdateRuleRunStatusRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateRuleRunStatus(request));
		}
		
		{
			CreateForwardRequest request = new CreateForwardRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateForward(request));
		}
		
		{
			UpdateForwardRequest request = new UpdateForwardRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateForward(request));
		}
		
		{
			DeleteForwardRequest request = new DeleteForwardRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteForward(request));
		}
		
		{
			GetForwardsRequest request = new GetForwardsRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetForwards(request));
		}
		
		client.shutdown();
	}

}
