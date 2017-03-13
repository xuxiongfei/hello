package com.chemgood.web;

import com.chemgood.service.ProductService;
import com.chemgood.web.common.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yuyi on 3/12/17.
 */
@Controller
public class ProductAction  extends BaseAction {
    @Resource
    ProductService productService;

    @RequestMapping(value="/chemgood/queryProductById")
    public void queryProductById(HttpServletResponse resp, HttpServletRequest req, Long id) throws IOException {
        getResult(resp, productService.queryProductById(id).toString());
        log.error("test success");
    }

}
