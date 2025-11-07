//package org.bluebridge.protobuf.test;
//
//import lombok.extern.slf4j.Slf4j;
//import org.bluebridge.protobuf.proto.ColorProto;
//import org.junit.Test;
//
///**
// * @author lingwh
// * @desc 测试 Protobuf 枚举
// * @date 2025/11/7 15:19
// */
//@Slf4j
//public class ProtobufOfColorEnumTest {
//
//    /**
//     * 测试 Color 枚举的基本使用
//     */
//    @Test
//    public void testColorEnum() {
//        // 创建不同的颜色枚举值
//        ColorProto.Color red = ColorProto.Color.COLOR_RED;
//        ColorProto.Color green = ColorProto.Color.COLOR_GREEN;
//        ColorProto.Color blue = ColorProto.Color.COLOR_BLUE;
//        log.info("Red: {}", red);
//        log.info("Green: {}", green);
//        log.info("Blue: {}", blue);
//
//        // 遍历所有枚举值
//        log.info("\nAll available colors:");
//        for (ColorProto.Color color : ColorProto.Color.values()) {
//            log.info("- {} ({})", color.name(), color.getNumber());
//        }
//    }
//
//    /**
//     * 测试 ColorMessage 的序列化和反序列化
//     */
//    @Test
//    public void testEnumSerialization() {
//        try {
//            // 创建 Colo 实例
//            ColorProto.ColorMessage message = ColorProto.Color.newBuilder()
//                    .setColor(ColorProto.Color.COLOR_GREEN)
//                    .setDescription("This is a green color")
//                    .build();
//
//            // 获取 ColorMessage 的字节数组表示
//            byte[] serializedData = message.toByteArray();
//            System.out.println("\nSerialized data length: " + serializedData.length + " bytes");
//
//            // 反序列化 ColorMessage
//        }
//    }
//    private static void testSerialization() {
//        try {
//            // 创建 ColorMessage 实例
//            ColorProto.ColorMessage message = ColorProto.ColorMessage.newBuilder()
//                    .setColor(ColorProto.Color.COLOR_GREEN)
//                    .setDescription("This is a green color")
//                    .build();
//
//            // 序列化为字节数组
//            byte[] serializedData = message.toByteArray();
//            System.out.println("\nSerialized data length: " + serializedData.length + " bytes");
//
//            // 反序列化回对象
//            ColorProto.ColorMessage deserializedMessage = ColorProto.ColorMessage.parseFrom(serializedData);
//
//            System.out.println("Deserialized color: " + deserializedMessage.getColor());
//            System.out.println("Deserialized description: " + deserializedMessage.getDescription());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
