package com.chemgood.service;

import com.chemgood.bean.ProductDO;
import com.sun.istack.internal.NotNull;

/**
 * Created by yuyi on 3/12/17.
 */
public interface ProductService {

    /**
     * 通过id查询产品
     * @param id [not null]
     */
    public ProductDO queryProductById(@NotNull Long id);
}
