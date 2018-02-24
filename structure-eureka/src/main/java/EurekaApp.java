import com.jyall.service.MsgSenderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/* =======================================================
 * 小窝
 * 日 期：10/17/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：注册中心启动类
 * ========================================================
 */
@EnableEurekaServer
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class EurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class,args);
//        new SpringApplicationBuilder(EurekaApp.class).web(true).run(args);
        System.out.println("启动成功");
    }
}
