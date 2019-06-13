package com.okami.apps.ej.bean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotBlank;

@ApiModel("顾客模型")
public class Customer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_customer.id
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_customer.telephone
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    @ApiParam(value = "手机号",required = true)
    @NotBlank(message = "手机号不能为空")
    private String telephone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_customer.password
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_customer.realname
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    private String realname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_customer.status
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ej_customer.photo
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    private String photo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_customer.id
     *
     * @return the value of ej_customer.id
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_customer.id
     *
     * @param id the value for ej_customer.id
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_customer.telephone
     *
     * @return the value of ej_customer.telephone
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_customer.telephone
     *
     * @param telephone the value for ej_customer.telephone
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_customer.password
     *
     * @return the value of ej_customer.password
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_customer.password
     *
     * @param password the value for ej_customer.password
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_customer.realname
     *
     * @return the value of ej_customer.realname
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_customer.realname
     *
     * @param realname the value for ej_customer.realname
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_customer.status
     *
     * @return the value of ej_customer.status
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_customer.status
     *
     * @param status the value for ej_customer.status
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ej_customer.photo
     *
     * @return the value of ej_customer.photo
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ej_customer.photo
     *
     * @param photo the value for ej_customer.photo
     *
     * @mbg.generated Mon Jun 10 11:24:36 CST 2019
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
}