package ex1;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;

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

        System.out.println("Valorp por defecto de size "+ hashTable.size());

        //Comprobar el valor y la clave si entan bíen.
        hashTable.put("1", "Valor 1");
        assertEquals("Valor 1", hashTable.get("1"));

        hashTable.put("2", "Valor1");

        // Remplazar el valor de una clave
        hashTable.put("2", "Valor 2");
        assertEquals("Valor 2" , hashTable.get("2"));


        // Probar un toString()
        hashTable.put("50", "Valor 50");
        assertEquals("\n bucket[1] = [1, Valor 1]\n bucket[2] = [2, Valor 2]\n bucket[11] = [50, Valor 50]", hashTable.toString());

        // Poner dos claves en mismo buket[0], (colisionar)
        hashTable.put("11", "Valor 11");
        hashTable.put("22","Valor 22");

        // Comprobar el valor correcto de segunda clave del un buket[0]
        assertEquals("Valor 22", hashTable.get("22"));

        // Cambiar el valor de segunda clave del un buket[0].
        hashTable.put("22", "Valor 23");
        assertEquals("Valor 23", hashTable.get("22"));


        // Comprobar el valor vacio
        hashTable.put("7" , "");
        assertEquals("" ,hashTable.get("7"));

        System.out.println(hashTable.toString() + "\n");


        // Comprobar el tamaño de los elementos
        assertEquals( 6, hashTable.size());
        System.out.println("Valor actual de size " + hashTable.size());

        // Comprobar el tamaño real de la tabla
        assertEquals(16 ,hashTable.realSize());
        System.out.println("Tamaño de tabla " + hashTable.realSize());

    }

    @org.junit.jupiter.api.Test
    void get() {
        HashTable hashTable = new HashTable();
        hashTable.put("11", "Get 11");
        hashTable.put("22", "Get 22");

        // Comprobar el valor de una clave
        assertEquals("Get 22" , hashTable.get("22"));

        // Comprobar el valor vacio de una clave
        hashTable.put("2", "");
        assertEquals("", hashTable.get("2"));

//        assertEquals(null, "3");
        System.out.println(hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void drop() {
        HashTable hashTable = new HashTable();
        hashTable.put("1", "Drop 1");
        hashTable.put("2", "Daop 2");
        hashTable.put("30", "Drop 30");

        //Mostrar la tabla
        System.out.println(hashTable.toString() + "\n");

        // Comprobar el size
        System.out.println("Valor actula de size es => " + hashTable.size());
        assertEquals(3 , hashTable.size());

        //drop de un buket
        hashTable.drop("30");

        // Comprobar el valor de size, despues de hacer el drop.
        System.out.println("Valor despues de hacer un drop es => " + hashTable.size());
        assertEquals(2, hashTable.size());

        System.out.println("\n*************************************");
        System.out.println("*************************************");

        // Añadir dos claves al mismo buket
        hashTable.put("3", "Drop 3");
        hashTable.put("12", "Drop 12");
        assertEquals("Drop 12", hashTable.get("12"));
        System.out.println(hashTable.toString()+ "\n");


        System.out.println("Aqui hago un drop de clave [12]");

        // Hacer un drop de segunda clave y su valor de un buket[1].
        // Comprobar el size, tiene que tener mismo valor
        hashTable.drop("12");
        System.out.println(hashTable.toString());
        assertEquals(3, hashTable.size());
        System.out.println("\nEl tamaño actual de los elementos : " + hashTable.size());

        System.out.println("\nTamaño de tabla " + hashTable.realSize());
        // Comprobar el tamaño real de la tabla
        assertEquals(16 ,hashTable.realSize());
    }


    @org.junit.jupiter.api.Test
    void testToString() {
    }


}