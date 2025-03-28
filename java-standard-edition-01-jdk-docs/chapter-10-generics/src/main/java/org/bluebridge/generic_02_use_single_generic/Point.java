package org.bluebridge.generic_02_use_single_generic;

import lombok.Data;

/**
 * 单个泛型
 * @param <T>
 */
@Data
public class Point<T> {
    // 表示X坐标
    private T x;
    // 表示Y坐标
    private T y;
}
