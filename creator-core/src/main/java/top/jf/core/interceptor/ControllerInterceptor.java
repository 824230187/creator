/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.core.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/12
 * @time 13:38
 */
public class ControllerInterceptor implements HandlerInterceptor{
	
	/**
	 * spring控制拦截器
	 * 记录信息:1.访问时间
	 *        2.Controller路径
	 *        3.对应方法名
	 *        4.请求参数信息
	 *        5.请求相对路径
	 *        6.请求处理时长
	 * */
	private final Logger logger = LoggerFactory.getLogger (ControllerInterceptor.class);
	
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis ();
		request.setAttribute ("startTime", startTime);
		
		HandlerMethod h = (HandlerMethod) handler;
		logger.info ("");
		logger.info ("--------------------------请求开始--------------------------------");
		logger.info ("请求的Controller: {}", h.getBean ().getClass ().getName ());
		logger.info ("请求控制器方法名： {}", h.getMethod ().getName ());
		logger.info ("请求参数信息：{}", getParamString (request.getParameterMap ()));
		logger.info ("请求的URL：{}", request.getRequestURL ());
		
		return true;
	}
	
	@Override
	public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler,
	                        ModelAndView modelAndView) throws Exception {
		long startTime = (long) request.getAttribute ("startTime");
		long endTime = System.currentTimeMillis ();
		long executeTime = endTime-startTime;
		logger.info ("--------------------------请求结束--------------------------------");
		logger.info ("本次请求耗时：{}ms\n",executeTime);
	}
	
	private String getParamString(Map<String, String[]> map) {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,String[]> e:map.entrySet()){
			sb.append(e.getKey()).append("=");
			String[] value = e.getValue();
			if(value != null && value.length == 1){
				sb.append(value[0]).append("\t");
			}else{
				sb.append(Arrays.toString(value)).append("\t");
			}
		}
		return sb.toString();
	}
	
	@Override
	public void afterCompletion (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
	                             Object o, Exception e) throws Exception {
		
	}
}
