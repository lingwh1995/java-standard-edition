package org.bluebridge.data;

import lombok.Data;

/**
 * @author lingwh
 * @desc User实体，@Data = @Getter + @Setter + @ToString + @EqualsAndHashCode + @NoArgsConstructor
 * @date 2025/8/18 11:41
 */
@Data
public class User {
    private String id;
    private String name;
    private int age;
    private String email;
}
