package wo.esys.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import wo.common.exception.WoException;
import wo.common.util.WoUtil;
import wo.esys.mapper.MenuMapper;
import wo.esys.po.Menu;
import wo.esys.po.User;
import wo.esys.service.CoreService;
import wo.esys.util.ESysConstant;
import wo.esys.vo.WoUser;

@Transactional
@Service
public class CoreServiceImpl implements CoreService {

	@Resource
	private MenuMapper menuMapper;
	

	
	@Override
	public List<Menu> findChildren(String parentId) {
	
		// 查询所有子菜单
		List<Menu> allChildMenus = menuMapper.findAllByParentId(parentId);
		
			return allChildMenus;
		
	}
	
}
