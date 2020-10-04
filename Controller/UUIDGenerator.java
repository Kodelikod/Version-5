package Controller;

import java.util.UUID;

public class UUIDGenerator {
// 28 bit value.
    public static void main (String [] args){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }

}
