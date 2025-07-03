package org.bluebridge.beanutils.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ronin
 * @version V1.0
 * @description
 * @class Person
 * @date 2019/6/20 15:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String userName;
    private String password;
    private Date hireDate;

}
