package com.ecm.cnpe.exchange.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecm.cnpe.exchange.utils.OptionLogger;
import com.ecm.common.util.JSONUtils;
import com.ecm.core.ActionContext;
import com.ecm.core.entity.EcmGroup;
import com.ecm.core.entity.EcmUser;
import com.ecm.core.entity.Pager;
import com.ecm.core.exception.AccessDeniedException;
import com.ecm.core.service.ExcSynDetailService;
import com.ecm.core.service.GroupService;
import com.ecm.core.service.UserService;
import com.ecm.portal.controller.ControllerAbstract;
import com.ecm.portal.util.CustomInfo;

/**
 * 角色组控制器
 * 
 * @author Administrator
 *
 */
@Controller
public class ExcGroupController extends ControllerAbstract {

	@Autowired
	private GroupService groupService;
	@Autowired
	private UserService userService;
	@Autowired
	private ExcSynDetailService detailService;

	@RequestMapping(value = "/exc/addToGroup", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addToGroup(@RequestBody String argStr) throws Exception {
		Map<String, Object> args = JSONUtils.stringToMap(argStr);
		boolean result = groupService.addUserToGroup(getToken(), args.get("userId").toString(),
				args.get("deptId").toString());
		
		EcmUser user= userService.getObjectById(this.getToken(), args.get("userId").toString());
		
		EcmGroup group= groupService.getObjectById(getToken(), args.get("deptId").toString());
		
		if(CustomInfo.OwnerCompany.equals(this.getSession().getCurrentUser().getCompany())) {
			OptionLogger.loggerGroup(getToken(), detailService, user, group.getName(),user.getCompanyName(),"添加到角色");
		}else {
			OptionLogger.loggerGroup(getToken(), detailService, user, group.getName(),CustomInfo.OwnerCompany,"添加到角色");
		}
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("code", result ? ActionContext.SUCESS : ActionContext.FAILURE);
		return mp;
	}
	
	
}
