package com.bs.dao.mapping;

import com.bs.dao.entity.Dormitory;
import com.bs.dao.entity.DormitoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DormitoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    int countByExample(DormitoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    int deleteByExample(DormitoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    int insert(Dormitory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    int insertSelective(Dormitory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    List<Dormitory> selectByExample(DormitoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    Dormitory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Dormitory record, @Param("example") DormitoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Dormitory record, @Param("example") DormitoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Dormitory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dormitory
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Dormitory record);
}