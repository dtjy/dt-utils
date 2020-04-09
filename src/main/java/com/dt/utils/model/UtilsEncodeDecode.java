package com.dt.utils.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "utils_encode_decode")
public class UtilsEncodeDecode {
    /**
     * 主键id,	自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String base64;

    @Column(name = "base64_base64")
    private String base64Base64;

    private String md5;

    @Column(name = "md5_md5")
    private String md5Md5;

    @Column(name = "md5_md5_md5")
    private String md5Md5Md5;

    @Column(name = "md5_base64")
    private String md5Base64;

    @Column(name = "base64_md5")
    private String base64Md5;

    private String sha1;

    @Column(name = "sha1_sha1")
    private String sha1Sha1;

    @Column(name = "md5_sha1")
    private String md5Sha1;

    @Column(name = "sha1_md5")
    private String sha1Md5;

    @Column(name = "sha1_base64")
    private String sha1Base64;

    @Column(name = "base64_sha1")
    private String base64Sha1;

    /**
     * 记录创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取主键id,	自增
     *
     * @return id - 主键id,	自增
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id,	自增
     *
     * @param id 主键id,	自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return base64
     */
    public String getBase64() {
        return base64;
    }

    /**
     * @param base64
     */
    public void setBase64(String base64) {
        this.base64 = base64;
    }

    /**
     * @return base64_base64
     */
    public String getBase64Base64() {
        return base64Base64;
    }

    /**
     * @param base64Base64
     */
    public void setBase64Base64(String base64Base64) {
        this.base64Base64 = base64Base64;
    }

    /**
     * @return md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * @param md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * @return md5_md5
     */
    public String getMd5Md5() {
        return md5Md5;
    }

    /**
     * @param md5Md5
     */
    public void setMd5Md5(String md5Md5) {
        this.md5Md5 = md5Md5;
    }

    /**
     * @return md5_md5_md5
     */
    public String getMd5Md5Md5() {
        return md5Md5Md5;
    }

    /**
     * @param md5Md5Md5
     */
    public void setMd5Md5Md5(String md5Md5Md5) {
        this.md5Md5Md5 = md5Md5Md5;
    }

    /**
     * @return md5_base64
     */
    public String getMd5Base64() {
        return md5Base64;
    }

    /**
     * @param md5Base64
     */
    public void setMd5Base64(String md5Base64) {
        this.md5Base64 = md5Base64;
    }

    /**
     * @return base64_md5
     */
    public String getBase64Md5() {
        return base64Md5;
    }

    /**
     * @param base64Md5
     */
    public void setBase64Md5(String base64Md5) {
        this.base64Md5 = base64Md5;
    }

    /**
     * @return sha1
     */
    public String getSha1() {
        return sha1;
    }

    /**
     * @param sha1
     */
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    /**
     * @return sha1_sha1
     */
    public String getSha1Sha1() {
        return sha1Sha1;
    }

    /**
     * @param sha1Sha1
     */
    public void setSha1Sha1(String sha1Sha1) {
        this.sha1Sha1 = sha1Sha1;
    }

    /**
     * @return md5_sha1
     */
    public String getMd5Sha1() {
        return md5Sha1;
    }

    /**
     * @param md5Sha1
     */
    public void setMd5Sha1(String md5Sha1) {
        this.md5Sha1 = md5Sha1;
    }

    /**
     * @return sha1_md5
     */
    public String getSha1Md5() {
        return sha1Md5;
    }

    /**
     * @param sha1Md5
     */
    public void setSha1Md5(String sha1Md5) {
        this.sha1Md5 = sha1Md5;
    }

    /**
     * @return sha1_base64
     */
    public String getSha1Base64() {
        return sha1Base64;
    }

    /**
     * @param sha1Base64
     */
    public void setSha1Base64(String sha1Base64) {
        this.sha1Base64 = sha1Base64;
    }

    /**
     * @return base64_sha1
     */
    public String getBase64Sha1() {
        return base64Sha1;
    }

    /**
     * @param base64Sha1
     */
    public void setBase64Sha1(String base64Sha1) {
        this.base64Sha1 = base64Sha1;
    }

    /**
     * 获取记录创建时间
     *
     * @return create_time - 记录创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置记录创建时间
     *
     * @param createTime 记录创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}