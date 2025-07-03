package org.bluebridge.beanutils.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ronin
 * @version V1.0
 * @description
 * @class User
 * @date 2019/6/20 14:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String name;
    private Integer age;
    private String school;

}
