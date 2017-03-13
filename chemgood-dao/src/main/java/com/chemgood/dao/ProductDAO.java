package com.chemgood.dao;

import com.chemgood.bean.ProductDO;
import com.sun.istack.internal.NotNull;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by yuyi on 3/12/17.
 * 产品相关数据库操作
 */
@Component
public interface ProductDAO {

    ProductDO queryProductNameById(@NotNull @Param("id") Long id);
}