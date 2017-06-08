package com.handy.frame.server.web.session;


/**
* @ClassName: ISession
* @Description: 自定义Session接口
* @author longhairen
* @date 2017年4月22日 下午3:00:26
*
* @param <V>
*/
public interface ISession<V> {
    /**
     * 设置真实session
     * init
     * @param session
     * @return void
     * @since:0.6
     */
    void init(javax.servlet.http.HttpSession session);
    
    /**
     * 设置session属性
     * setObject
     * @param k
     * @param v
     * @return void
     * @since:0.6
     */
    void setObject(String k, V v);
    
    /**
     * 读取session属性
     * getObject
     * @param k
     * @return
     * @return V
     * @since:0.6
     */
    V getObject(String k);
    
    /**
     * session失效
     * invalidate
     * @return void
     * @since:0.6
     */
    void invalidate();
    
    /**
     * 获取sessionId
     * @return
     * @see
     */
    String getId();
    
    /**
     * 获取session有效期
     * @return
     * @see
     */
    int getMaxInactiveInterval();
}
