package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by jason on 2019/4/28.
 */

@Component
@Data
public class GirlConfig {

    private String name;

    private Integer age;



}
