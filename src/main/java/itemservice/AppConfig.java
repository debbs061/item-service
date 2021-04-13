package itemservice;

import itemservice.service.ItemService;
import itemservice.service.ItemServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl();
    }
}
