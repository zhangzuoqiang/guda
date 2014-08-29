package it.pkg.dao;

import it.pkg.dao.domain.DemoDO;
import it.pkg.dao.domain.DemoDOCriteria;
import java.util.List;

public interface DemoDOMapper {
    int countByExample(DemoDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(DemoDO record);

    int insertSelective(DemoDO record);

    List<DemoDO> selectByExample(DemoDOCriteria example);

    DemoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DemoDO record);

    int updateByPrimaryKey(DemoDO record);
}