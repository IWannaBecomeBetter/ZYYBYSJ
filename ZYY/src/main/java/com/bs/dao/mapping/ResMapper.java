package com.bs.dao.mapping;

import com.bs.dao.entity.Res;
import com.bs.dao.entity.ResExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    int countByExample(ResExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    int deleteByExample(ResExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    int insert(Res record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    int insertSelective(Res record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    List<Res> selectByExample(ResExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    Res selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Res record, @Param("example") ResExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Res record, @Param("example") ResExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Res record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table res
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Res record);
}