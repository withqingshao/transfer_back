package com.zsq.datatransfer.mapper;

import com.zsq.datatransfer.model.TransferDatasourceParam;
import com.zsq.datatransfer.model.TransferDatasourceParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransferDatasourceParamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    long countByExample(TransferDatasourceParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    int deleteByExample(TransferDatasourceParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    int insert(TransferDatasourceParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    int insertSelective(TransferDatasourceParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    List<TransferDatasourceParam> selectByExample(TransferDatasourceParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    TransferDatasourceParam selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    int updateByExampleSelective(@Param("record") TransferDatasourceParam record, @Param("example") TransferDatasourceParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    int updateByExample(@Param("record") TransferDatasourceParam record, @Param("example") TransferDatasourceParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    int updateByPrimaryKeySelective(TransferDatasourceParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_datasource_param
     *
     * @mbg.generated Thu Aug 08 10:16:48 CST 2019
     */
    int updateByPrimaryKey(TransferDatasourceParam record);
}