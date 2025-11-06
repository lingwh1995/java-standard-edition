package org.bluebridge;

import lombok.extern.slf4j.Slf4j;
import org.bluebridge.protobuf.domain.ContactProto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author lingwh
 * @desc 测试 Protobuf 测试联系人读取
 * @date 2025/11/6 23:59
 */
@Slf4j
public class ProtobufOfContactsReadTest {

    public static void main(String[] args) throws IOException {
        // 读取文件，将内容进行反序列化
        FileInputStream inputStream = new FileInputStream("d:/contacts.bin");
        // 反序列化
        ContactProto.Contacts contacts = ContactProto.Contacts.parseFrom(inputStream);

        // 打印联系人信息
        contacts.getContactsList().forEach(peopleInfo -> {
            log.info("姓名：{}，年龄：{}", peopleInfo.getName(), peopleInfo.getAge());
            peopleInfo.getPhonesList().forEach(phone -> {
                log.info("手机号：{}", phone.getNumber());
            });
        });
    }

}
