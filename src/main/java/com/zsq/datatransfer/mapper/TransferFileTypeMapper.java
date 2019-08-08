package com.zsq.datatransfer.mapper;

import com.zsq.datatransfer.model.TransferFileType;
import com.zsq.datatransfer.model.TransferFileTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransferFileTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    long countByExample(TransferFileTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    int deleteByExample(TransferFileTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    int deleteByPrimaryKey(Integer fileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    int insert(TransferFileType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    int insertSelective(TransferFileType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    List<TransferFileType> selectByExample(TransferFileTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    TransferFileType selectByPrimaryKey(Integer fileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") TransferFileType record, @Param("example") TransferFileTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    int updateByExample(@Param("record") TransferFileType record, @Param("example") TransferFileTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    int updateByPrimaryKeySelective(TransferFileType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transfer_file_type
     *
     * @mbg.generated Thu Aug 08 15:36:56 CST 2019
     */
    int updateByPrimaryKey(TransferFileType record);
}