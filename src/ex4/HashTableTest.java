package ex4;

import ex1.HashTable;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTableTest {

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
        hashTable.put("0", "Valor 0");
        hashTable.put("11", "Valor 11");
        hashTable.put("22","Valor 22");

        // Comprobar el valor correcto de segunda clave del un buket[0]
        assertEquals("Valor 22", hashTable.get("22"));

        // Cambiar el valor de segunda clave del un buket[0].
        System.out.println(hashTable.toString());
        hashTable.put("22", "Valor 23");
        assertEquals("Valor 23", hashTable.get("22"));
        System.out.println(hashTable.toString());


        // Cambiar el valor colisionado que está en medio
       hashTable.put("11", "Valor 11 cambiado por 111");


        // Comprobar el valor vacio
        hashTable.put("7" , "");
        assertEquals("" ,hashTable.get("7"));

        System.out.println(hashTable.toString() + "\n");


        // Comprobar el tamaño de los elementos
        assertEquals( 7, hashTable.size());
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
        hashTable.put("33", "Get 33");

        // Comprobar el valor de una clave
        assertEquals("Get 22" , hashTable.get("22"));

        // Comprobar el valor de una clave que están medio
        assertEquals("Get 33" , hashTable.get("33"));

        // Comprobar el valor esta nulo
        hashTable.put("2", null);
        assertEquals(null, hashTable.get("2"));

        // Comprobar el toString
        assertEquals("\n bucket[0] = [11, Get 11] -> [22, Get 22] -> [33, Get 33]\n" + " bucket[2] = [2, null]" , hashTable.toString());

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

        // Comprobar el toString
        assertEquals("\n bucket[1] = [1, Drop 1]\n" +
                " bucket[2] = [2, Daop 2]\n" +
                " bucket[3] = [3, Drop 3]", hashTable.toString());


        System.out.println("\nEl tamaño actual de los elementos : " + hashTable.size());

        System.out.println("\nTamaño de tabla " + hashTable.realSize());
        // Comprobar el tamaño real de la tabla
        assertEquals(16 ,hashTable.realSize());
    }

    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();

        //Comprobar el tamaño del método size antes de hacer los puts y drops
        assertEquals(0, hashTable.size());

        // Ahora hemos creado tres elementos y vamos a comprobar el tamaño del size. Deberiá cambiar el valor del método size = 3
        hashTable.put("1", "Size 1");
        hashTable.put("2", "Size 2");
        hashTable.put("30", "Size 30");
        System.out.println(hashTable.toString());
        assertEquals(3, hashTable.size());

        // Comprobar el tamaño despues de hacer un drop (2)
        hashTable.drop("30");
        assertEquals(2,hashTable.size());

        hashTable.put("11", "Size 11");
        hashTable.put("22", "Size 22");


        // Comprobar el tamaño después de hacer un drop de un elemento que esta en medio
        hashTable.drop("11");
        assertEquals(3 , hashTable.size());

    }

    @org.junit.jupiter.api.Test
    void realSize() {
        HashTable hashTable = new HashTable();

        //Comprobar el tamaño del método realsize antes de hacer los puts y drops
        assertEquals(16, hashTable.realSize());

        // Ahora hemos creado tres elementos y vamos a comprobar el tamaño del realsize, no deberiá cambiar nada.
        hashTable.put("1", "Real Size 1");
        hashTable.put("2", "Real Size 2");
        hashTable.put("30", "Real Size 30");
        System.out.println(hashTable.toString());
        assertEquals(16, hashTable.realSize());

        // Comprobar el tamaño del realSize despúes de hacer un drop.
        hashTable.drop("30");
        assertEquals(16,hashTable.realSize());

        // Añadir dos valores en un buket.
        hashTable.put("11", "Size 11");
        hashTable.put("22", "Size 22");
        assertEquals(16, hashTable.realSize());

        // Comprobar el tamaño después de hacer un drop de un elemento que esta en medio.
        hashTable.drop("11");
        assertEquals(16 , hashTable.realSize());

        // Comprobar el realsize cuando el valor está en nulo.
        hashTable.put("3", null);
        assertEquals(16 , hashTable.realSize());
        System.out.println("\nEl tamaño actual de los elementos : " + hashTable.size());

    }
}