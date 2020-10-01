package com.ecm.cnpe.exchange.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.ecm.cnpe.exchange.utils.OptionLogger;
import com.ecm.common.util.JSONUtils;
import com.ecm.core.ActionContext;
import com.ecm.core.entity.EcmGroup;
import com.ecm.core.entity.EcmUser;
import com.ecm.core.entity.Pager;
import com.ecm.core.exception.AccessDeniedException;
import com.ecm.core.exception.EcmException;
import com.ecm.core.exception.NoPermissionException;
import com.ecm.core.service.ExcSynDetailService;
import com.ecm.core.service.GroupService;
import com.ecm.core.service.UserService;
import com.ecm.portal.controller.ControllerAbstract;
import com.ecm.portal.util.CustomInfo;

/**
 * 用户控制器
 * 
 * @author Administrator
 *
 */
@Controller
public class ExcUserController extends ControllerAbstract {

	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	@Autowired
	private ExcSynDetailService detailService;

	

	/**
	 * 更新用户
	 * 
	 * @param obj 用户实例
	 * @return
	 */
	@RequestMapping(value = "/exc/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateUser(@RequestBody EcmUser obj) {
		Map<String, Object> mp = new HashMap<String, Object>();
		try {
			userService.updateObject(getToken(), obj);
			if(CustomInfo.OwnerCompany.equals(this.getSession().getCurrentUser().getCompany())) {
				OptionLogger.loggerUser(getToken(), detailService, obj, obj.getCompanyName(),"修改用户");
			}else {
				OptionLogger.loggerUser(getToken(), detailService, obj, CustomInfo.OwnerCompany,"修改用户");
			}
			mp.put("code", ActionContext.SUCESS);
		} catch (EcmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mp.put("code", ActionContext.FAILURE);
			mp.put("message", e.getMessage());
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			mp.put("code", ActionContext.TIME_OUT);
			mp.put("message", e.getMessage());
		} catch (NoPermissionException e) {
			// TODO Auto-generated catch block
			mp.put("code", ActionContext.NO_PERMSSION);
			mp.put("message", e.getMessage());
		}
		return mp;
	}

	

	/**
	 * 新建用户
	 * 
	 * @param obj 用户实例
	 * @return
	 */
	@RequestMapping(value = "/exc/newUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> newUser(String user, MultipartFile uploadFile) {
		Map<String, Object> mp = new HashMap<String, Object>();
		EcmUser en = JSON.parseObject(user, EcmUser.class);
		try {
			InputStream instream = null;
			String fileName = null;
			if (uploadFile != null) {
				instream = uploadFile.getInputStream();
				fileName = uploadFile.getOriginalFilename();
			}
			userService.newObject(getToken(), en, instream, fileName);
			if(CustomInfo.OwnerCompany.equals(this.getSession().getCurrentUser().getCompany())) {
				OptionLogger.loggerUser(getToken(), detailService, en, en.getCompanyName(),"新建用户");
			}else {
				OptionLogger.loggerUser(getToken(), detailService, en, CustomInfo.OwnerCompany,"新建用户");
			}
			
			if (instream != null) {
				instream.close();
			}
			mp.put("code", ActionContext.SUCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mp.put("code", ActionContext.FAILURE);
			mp.put("message", e.getMessage());
		}
		return mp;
	}

	

	@RequestMapping(value = "/exc/removeUserRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> removeUser(@RequestBody String argStr) {
		Map<String, Object> mp = new HashMap<String, Object>();
		try {
			Map<String, Object> args = JSONUtils.stringToMap(argStr);
			groupService.removeUserFromRole(getToken(), args.get("userId").toString(), args.get("roleId").toString());
			EcmUser user= userService.getObjectById(this.getToken(), args.get("userId").toString());
			
			EcmGroup group= groupService.getObjectById(getToken(), args.get("roleId").toString());
			
			if(CustomInfo.OwnerCompany.equals(this.getSession().getCurrentUser().getCompany())) {
				OptionLogger.loggerGroup(getToken(), detailService, user, group.getName(),user.getCompanyName(),"移除用户");
			}else {
				OptionLogger.loggerGroup(getToken(), detailService, user, group.getName(),CustomInfo.OwnerCompany,"移除用户");
			}
			
			mp.put("code", ActionContext.SUCESS);
		} catch (EcmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mp.put("code", ActionContext.FAILURE);
			mp.put("message", e.getMessage());
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			mp.put("code", ActionContext.TIME_OUT);
			mp.put("message", e.getMessage());
		} catch (NoPermissionException e) {
			// TODO Auto-generated catch block
			mp.put("code", ActionContext.NO_PERMSSION);
			mp.put("message", e.getMessage());
		}
		return mp;
	}
}
