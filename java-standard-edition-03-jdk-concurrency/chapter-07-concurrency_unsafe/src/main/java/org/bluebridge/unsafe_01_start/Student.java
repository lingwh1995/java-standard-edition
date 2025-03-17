package org.bluebridge.unsafe_01_start;

import lombok.Data;

@Data
class Student {
    volatile int id;
    volatile String name;
}
