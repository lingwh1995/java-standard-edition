package org.bluebridge.enumeration;

import org.junit.Test;

public class ModifyEnumTest {

    /**
     * 测试获取枚举中存储的值
     */
    @Test
    public void test() {
        ModifyEnum[] modifies = ModifyEnum.values();
        for(ModifyEnum modify:modifies){
			System.out.println(modify.getCode() + ":" + modify.getDesc());
		}
    }
}
