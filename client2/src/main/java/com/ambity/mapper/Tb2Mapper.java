package com.ambity.mapper;

import com.ambity.dto.Tb2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tb2Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb2
     *
     * @mbg.generated Sun Dec 06 10:16:08 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb2
     *
     * @mbg.generated Sun Dec 06 10:16:08 CST 2020
     */
    int insert(Tb2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb2
     *
     * @mbg.generated Sun Dec 06 10:16:08 CST 2020
     */
    int insertSelective(Tb2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb2
     *
     * @mbg.generated Sun Dec 06 10:16:08 CST 2020
     */
    Tb2 selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb2
     *
     * @mbg.generated Sun Dec 06 10:16:08 CST 2020
     */
    int updateByPrimaryKeySelective(Tb2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb2
     *
     * @mbg.generated Sun Dec 06 10:16:08 CST 2020
     */
    int updateByPrimaryKey(Tb2 record);
}