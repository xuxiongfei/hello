package com.chemgood.bo.impl;

import com.chemgood.bean.ProductDO;
import com.chemgood.bo.ProductBO;
import com.chemgood.dao.ProductDAO;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yuyi on 3/12/17.
 */
@Component("productBO")
public class ProductBOImpl implements ProductBO {

    @Autowired
    ProductDAO productDAO;

    public ProductDO queryProductById(@NotNull Long id) {
        return productDAO.queryProductNameById(id);
    }
}
