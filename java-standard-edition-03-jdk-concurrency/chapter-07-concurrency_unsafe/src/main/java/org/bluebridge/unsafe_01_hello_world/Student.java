package org.bluebridge.unsafe_01_hello_world;

import lombok.Data;

@Data
class Student {
    volatile int id;
    volatile String name;
}
