package com.zsq.datatransfer.model;

public class TransferDatasource {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transfer_datasource.datasource_id
     *
     * @mbg.generated Thu Aug 08 21:26:35 CST 2019
     */
    private Integer datasourceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transfer_datasource.name
     *
     * @mbg.generated Thu Aug 08 21:26:35 CST 2019
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transfer_datasource.datasource_id
     *
     * @return the value of transfer_datasource.datasource_id
     *
     * @mbg.generated Thu Aug 08 21:26:35 CST 2019
     */
    public Integer getDatasourceId() {
        return datasourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transfer_datasource.datasource_id
     *
     * @param datasourceId the value for transfer_datasource.datasource_id
     *
     * @mbg.generated Thu Aug 08 21:26:35 CST 2019
     */
    public void setDatasourceId(Integer datasourceId) {
        this.datasourceId = datasourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transfer_datasource.name
     *
     * @return the value of transfer_datasource.name
     *
     * @mbg.generated Thu Aug 08 21:26:35 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transfer_datasource.name
     *
     * @param name the value for transfer_datasource.name
     *
     * @mbg.generated Thu Aug 08 21:26:35 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}