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

        // Comprobar el size
        // System.out.println(hashTable.size());
        HashTable hashTable = new HashTable();

        System.out.println("Valorp por defecto de size "+ hashTable.size());

        //Comprobar el valor y la clave si entan bíen.
        hashTable.put("1", "Pratik");
        assertEquals("Pratik", hashTable.get("1"));

        hashTable.put("2", "Valor1");
        hashTable.put("2", "Valor2");

        //Añadir dos valores en
        System.out.println(hashTable.toString() + "\n");


        System.out.println("Valor actual de size " + hashTable.size());

        //comprobar el tamaño real de la tabla
        System.out.println("Tamaño de tabla " + hashTable.realSize());


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