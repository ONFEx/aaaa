package wo.esys.service;

import java.util.List;

import wo.esys.po.Menu;
import wo.esys.vo.WoUser;

public interface CoreService {

	List<Menu> findChildren (String parentId);

	
}
