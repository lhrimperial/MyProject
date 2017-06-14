package com.handy.frame;

import com.caucho.hessian.client.HessianProxyFactory;
import com.handy.frame.web.service.IHessianService;

import java.net.MalformedURLException;
import java.util.List;

/**
 * @author longhairen
 * @create 2017/6/14 0014 下午 3:20
 */
public class HessianClient {

    public static void main(String[] args) {
        String url = "http://localhost:8088/frame-web/SpaceHessian";
        HessianProxyFactory factory = new HessianProxyFactory();
        try {
            IHessianService spaceService = (IHessianService) factory.create(
                    IHessianService.class, url);
            System.out.println(spaceService.findSpace("testid"));
            System.out.println(spaceService.updateSpaceName("whatever"));

            List spaceNames = spaceService.showSpaceNames();
            System.out.println("\r\nGet space names:");
            for (int i = 0; i < spaceNames.size(); i++) {
                System.out.print(spaceNames.get(i) + ", ");
            }
            System.out.println();
            System.out.println("space names list finished");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
