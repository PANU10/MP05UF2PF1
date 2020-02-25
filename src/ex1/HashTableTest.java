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
        hashTable.put("1", "Valor 1");
        assertEquals("Valor 1", hashTable.get("1"));

        hashTable.put("2", "Valor1");

        // Remplazar el valor de una clave
        hashTable.put("2", "Valor 2");
        assertEquals("Valor 2" , hashTable.get("2"));

        System.out.println(hashTable.toString() + "\n");

        // Probar un toString()
        hashTable.put("50", "Valor 50");
        assertEquals("bucket[11] = [50, Valor 50]", hashTable.toString());


        assertEquals(2 , hashTable.size());
        System.out.println("Valor actual de size " + hashTable.size());

        //comprobar el tamaño real de la tabla
        assertEquals(16 ,hashTable.realSize());
        System.out.println("Tamaño de tabla " + hashTable.realSize());


    }

    @org.junit.jupiter.api.Test
    void get() {
        HashTable hashTable = new HashTable();
        hashTable.put("10", "Get 10");
        hashTable.put("20", "Get 20");
        //Probar el valor de una clave
        assertEquals("Get 20" , hashTable.get("20"));
//        assertEquals(null, "3");

    }

    @org.junit.jupiter.api.Test
    void drop() {
        HashTable hashTable = new HashTable();
        hashTable.put("30", "Drop 30");

        //drop de un hash
        hashTable.drop("30");
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }


}