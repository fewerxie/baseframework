package com.fewer.common.persistence.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fewer.common.utils.IdUtils;
import com.fewer.user.pojo.UserPOJO;
import com.fewer.user.utils.UserUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 数据Entity类
 *
 * @author DHC
 * @version 2014-05-16
 */
@Data
public abstract class CrudPOJO<T> extends BasePOJO<T> {

    private static final long serialVersionUID = 1L;

    /**
     * @Description: 实体编号（唯一标识）
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    protected String id;

    /**
     * @Description: 创建者
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    protected UserPOJO createBy;

    /**
     * @Description: 创建日期
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    protected Date createDate;

    /**
     * @Description: 更新者
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    protected UserPOJO updateBy;

    /**
     * @Description: 更新日期
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    protected Date updateDate;

    /**
     * @Description: 删除标记（0：正常；1：删除；）
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    protected String delFlag;

    /**
     * @Description: 备注
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    protected String remarks;

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    protected boolean isNewRecord = false;

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @return
     */
    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getId());
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (!this.isNewRecord) {
            setId(IdUtils.uuid());
        }
        UserPOJO userPOJO = UserUtils.getUser();
        this.updateBy = userPOJO;
        this.createBy = userPOJO;
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate() {
        UserPOJO userPOJO = UserUtils.getUser();
        this.updateBy = userPOJO;
        this.updateDate = new Date();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

}
