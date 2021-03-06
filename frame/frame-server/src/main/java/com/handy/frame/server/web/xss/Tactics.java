package com.handy.frame.server.web.xss;


/**
* @ClassName: Tactics
* @Description: 验证处理策略
* @author longhairen
* @date 2017年4月22日 下午3:05:03
*
*/
interface Tactics {
	/**
	 * 处理的逻辑方法
	 * @param target 目标对象,正则匹配的字符串
	 * @param regex  正则表达式
	 * @return
	 * @see
	 */
	String process(String target, String regex) throws ParametersValidatorException;
}