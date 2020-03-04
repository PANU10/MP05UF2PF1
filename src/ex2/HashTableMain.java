package ex2;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // Put some key values.

        /**
         * TODO Refacción :
         * he aplicado el método de refacción sobre el un método main que estaba dentro de la clase HashTable, por qué he considerado que el método main no va ahí si no fuera de la clase HashTable,
         * entonces he hecho un extracción de un métod a una clase
         *
         **/

        for (int i = 0; i < 30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, key);
        }

        // Print the HashTable structure
        HashTable.log("****   HashTable  ***");
        HashTable.log(hashTable.toString());
        HashTable.log("\nValue for key(20) : " + hashTable.get("20"));
    }
}