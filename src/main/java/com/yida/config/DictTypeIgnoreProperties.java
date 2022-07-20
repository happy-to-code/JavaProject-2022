package com.yida.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: 字典type被禁用后任然可继续使用的类型 配置
 *
 * @author qts
 * @date 2022/5/18 0018
 */
@Data
@Component
@ConfigurationProperties(prefix = "dict") // 前缀
public class DictTypeIgnoreProperties {
    /**
     * 对应属性名,与配置中相同
     */
    private List<String> ignores = new ArrayList<>();

    private List<Integer> ages;

    private String name;

}
