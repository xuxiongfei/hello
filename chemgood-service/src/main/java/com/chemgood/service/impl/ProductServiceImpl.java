package com.chemgood.service.impl;

import com.chemgood.bean.ProductDO;
import com.chemgood.bo.ProductBO;
import com.chemgood.service.ProductService;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yuyi on 3/12/17.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductBO productBO;

    public ProductDO queryProductById(@NotNull Long id) {
        return productBO.queryProductById(id);
    }
}
