(1)写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）, 提交到 GitHub。  请见bean-assemble-test项目  
顶层调用对象为DemoController  
DemoServiceImpl的1个实例service1与DemoController使用xml方式加载与装配  
DemoServiceImpl的第2个实例service2使用@Service("demoService2")加载，并以@Resource(name = "demoService2")方式与DemoController装配  
Tool对象使用@Component加载以及@Autowired方式装配  
Person对象使用@Configuration + @Bean方式加载以及@Autowired方式与DemoController装配  
  
(2)给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。  starter构建项目请见auto-config-test项目，starter引用测试项目为starter-test项目  
starter构建项目中，com.geek.spring.autoconfig.test.config.AutoConfigTest为入口配置类，spring.factories指定了让boot加载AutoConfigTest配置类  
具体构建starter步骤请参考有道笔记云笔记链接：  
http://note.youdao.com/noteshare?id=9774aa179b635c5195eb1d344b68180f&sub=999C27F45A334C319DD0539123E2BF5E  

(3)研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法。 请参见jdbc-test项目  
需求实现的类为com.geek.spring.jdbc.test.JdbcTest
