package wo.esys.util;

import wo.common.exception.WoResultCode;

public interface ESysConstant {
	String SESSION_USER = "eSysUser";
	
	WoResultCode ERR_LOGIN = new WoResultCode(501, "您还没有登录，请登录！");
	WoResultCode ERR_USER_PWD = new WoResultCode(502, "验证失败，用户名或者密码不正确！");
	
	WoResultCode ERR_USER_ROLE = new WoResultCode(503, "用户的角色信息设置有问题！");
	
	WoResultCode ERR_MENU_CHILD = new WoResultCode(500, "该菜单下还有关联的子菜单！");
}
