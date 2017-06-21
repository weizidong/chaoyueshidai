package xin.chaoyueshidai.module.config;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ConfigMapper {

	int countByExample(ConfigExample example);

	int deleteByExample(ConfigExample example);

	int deleteByPrimaryKey(String filed);

	int insert(Config record);

	int insertSelective(Config record);

	List<Config> selectByExample(ConfigExample example);

	Config selectByPrimaryKey(String filed);

	int updateByExampleSelective(@Param("record") Config record, @Param("example") ConfigExample example);

	int updateByExample(@Param("record") Config record, @Param("example") ConfigExample example);

	int updateByPrimaryKeySelective(Config record);

	int updateByPrimaryKey(Config record);
}