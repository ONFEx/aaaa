package wo.esys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import wo.esys.po.Menu;

@Mapper
public interface MenuMapper {
	

	
	List<Menu> findAllByParentId (@Param("parentId")String parentId);

	List<Menu> findAllBySearch(@Param("search")String searchContent);

	
	
}
