package ex1;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();
        System.out.println(hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void realSize() {
    }

    @org.junit.jupiter.api.Test
    void put() {

        HashTable hashTable = new HashTable();
        hashTable.put("1", "Pratik");
        hashTable.put("2", "Usuario2");
        hashTable.put("3", "Usuari3");
        hashTable.put("4", "Usuario4");

        System.out.println(hashTable.toString());
        System.out.println(hashTable.size());
        assertEquals("Pratik", hashTable.get("1"));
  //     assertEquals("10", hashTable.getCollisionsForKey("1", 1));

    }

    @org.junit.jupiter.api.Test
    void get() {
        HashTable hashTable = new HashTable();

    }

    @org.junit.jupiter.api.Test
    void drop() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}