package com.chemgood.web.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yuyi on 3/11/17.
 */
@Controller
public class BaseAction {
    protected Log log = LogFactory.getLog(this.getClass());


    /**
     * 将mikuresult中的内容转换成前端交互的resultmap 的JSON格式
     * @param resp
     * @return
     */
    public void getResult(HttpServletResponse resp, String data) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(data);
        out.flush();
        out.close();
    }
}
