package wo.esys.util;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wo.common.exception.WoException;
import wo.esys.vo.WoUser;

public class ESysUtil {
	private static Logger LOG = LogManager.getLogger(ESysUtil.class);
	
	public static WoUser getCurrentUser (Map<String, Object>map) {
		WoUser user = (WoUser)map.get(ESysConstant.SESSION_USER);
		
		if (user == null) {
			throw new WoException (ESysConstant.ERR_LOGIN);
		}
		return user;
	}
}
