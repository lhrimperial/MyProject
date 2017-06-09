package com.handy.frame.server.deploy;

import com.handy.frame.server.context.AppContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author longhairen
 * @date 2017年4月22日 下午2:53:30
 * 应用上下文监听器
 */
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    /**
     * 初始化应用上下文
     *
     * @param sce
     * @since:0.7
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     * contextInitialized
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        AppContext.initAppContext(sc.getServletContextName(),
                sc.getInitParameter("staticServerAddress"),
                sc.getContextPath());

    }
}
