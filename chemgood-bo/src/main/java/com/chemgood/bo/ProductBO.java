package com.chemgood.bo;

import com.chemgood.bean.ProductDO;
import com.sun.istack.internal.NotNull;

/**
 * Created by yuyi on 3/12/17.
 */
public interface ProductBO {

    /**
     * 通过id查询product信息
     * @param id
     * @return
     */
    public ProductDO queryProductById(@NotNull Long id);
}
