package wo.esys.service.Impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import wo.common.entity.WoPage;
import wo.common.exception.WoException;
import wo.common.util.WoUtil;
import wo.esys.mapper.MenuMapper;
import wo.esys.po.Menu;
import wo.esys.service.MenuService;
import wo.esys.util.ESysConstant;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	private static Logger LOG = LogManager.getLogger(MenuServiceImpl.class);

	@Resource
	private MenuMapper menuMapper;
	
	@Override
	public WoPage<Menu> getPageData(Integer page, Integer pageSize, String searchContent) {
		PageHelper.startPage(page, pageSize, "m.no");
		Page<Menu> pg = (Page<Menu>)menuMapper.findAllBySearch (searchContent);
		return new WoPage<Menu>(pg.getResult(), pg.getTotal());
	}


	
}
