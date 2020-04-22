package com.zhangyaoxing.entity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenhj
 * @since 2020-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Room implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "roomid", type = IdType.AUTO)
    private Integer roomid;

    private Integer rmCode;

    private Integer dmTypeId;

    private Integer status;


}
