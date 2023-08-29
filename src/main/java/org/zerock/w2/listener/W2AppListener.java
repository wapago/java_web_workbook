package org.zerock.w2.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Log4j2
public class W2AppListener implements ServletContextListener {

    // ServletContextEvent를 이용하면 현재 애플리케이션이 실행되는 공간인 ServletContext를 접근할 수 있다.
    // 스프링 프레임워크를 웹 프로젝트에서 미리 로딩하는 작업을 처리할 때 ServletContextListener를 이용한다.
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("-------------init------------------------");
        log.info("-------------init------------------------");
        log.info("-------------init------------------------");

        ServletContext servletContext = sce.getServletContext();

        servletContext.setAttribute("appName", "W2");
    }

    // ServletContextEvent는 쉽게 말해서 현재의 웹 애플리케이션 내 모든 자원들을 같이 사용하는 공간이다.
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("--------------------destroyed------------");
        log.info("--------------------destroyed------------");
        log.info("--------------------destroyed------------");
    }
}
