package wo.esys.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import wo.common.exception.WoResultCode;
import wo.esys.po.Menu;
import wo.esys.service.CoreService;
import wo.esys.util.ESysConstant;
import wo.esys.util.ESysUtil;
import wo.esys.vo.WoMenu;
@Controller
@SessionAttributes(ESysConstant.SESSION_USER)
public class HomeController {
	private final static Logger LOG = LogManager.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String toMain(){
		
		return "main";
	}
	
	@RequestMapping("/isLogin")
	@ResponseBody
	public WoResultCode isLogin(){
		
		return WoResultCode.getSuccessCode();
	}
	
	
	@Resource
	private CoreService coreService;
	
	/**
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/getChildren")
	@ResponseBody
	public List<WoMenu> getChildren(String id, Map<String, Object> map) {
		List<Menu> dtos = coreService.findChildren(id);
		return WoMenu.getVos(dtos);
	}
 }
