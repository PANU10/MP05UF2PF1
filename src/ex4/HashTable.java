package ex4;

// Original source code: https://gist.github.com/amadamala/3cdd53cb5a6b1c1df540981ab0245479
// Modified by Fernando Porrino Serrano for academic purposes.

import java.util.ArrayList;

/**
 * EL HashTable sirve para encontrar los elementos rapidamente de una colección de elementos.
 */
public class HashTable {
    private int INITIAL_SIZE = 16;
    private int size = 0;
    private HashEntry[] entries = new HashEntry[INITIAL_SIZE];

    /**
     * @return devulve el tamaño real de los elemtos creados.
     */
    public int size(){
        return this.size;
    }

    /**
     * @return Devuelve el tamaño de la tabla que siempre 16 en este caso.
     */
    public int realSize(){
        return this.INITIAL_SIZE;
    }

    /**
     * @param key Basicamente genera una clave y cada calve tiene su valor propio, Este objeto tiene que tener implementado el método .hasCode()
     * @param value sirve para asignar el valor a una clave.
     * El método en si, sirve para crear las entradas del hash.
     */
    public void put(String key, String value) {
        int hash = getHash(key);
        final HashEntry hashEntry = new HashEntry(key, value);


        if(entries[hash] == null) {
            entries[hash] = hashEntry;
            // Tamaño de los elementos añadidos
           // size++;
        }

        else {
            HashEntry temp = entries[hash];

            // Cambiar el valor de una clave si coincide las claves.
            if (temp.key.equals(key)) {
                entries[hash] = hashEntry;
                return;
            }


            while(temp.next != null){
                temp = temp.next;

                if (temp.key.equals(key)) {
                    temp.value = hashEntry.value;
                    return;
                }
            }
            temp.next = hashEntry;
            hashEntry.prev = temp;
           //Pratik  size++;
        }
        // Incrementar la variable al añadir un elemento.
        size++;
    }

    /**
     * Método que recupera el valor asociado a una clave de una Hashtable.
     * @param key Como he comentado anteriormente, devuele el valor de una clave.
     * @return Si la clave es nula se lanza una Excepción.
     */
    public String get(String key) {
        int hash = getHash(key);
        if(entries[hash] != null) {
            HashEntry temp = entries[hash];

            while( !temp.key.equals(key)){

                // En caso que sea nulo
                if (temp.next == null) return null;
                temp = temp.next;
            }


            return temp.value;
        }
        return null;
    }

    /**
     * El método sirve para quitar el elemento con la clave especificada de Hashtable.
     * @param key Asigna la clave que quieras quitar.
     */
    public void drop(String key) {

        int hash = getHash(key);
        if(entries[hash] != null) {

            HashEntry temp = entries[hash];
            while( !temp.key.equals(key))
                temp = temp.next;

            if(temp.prev == null) entries[hash] = null;
            else{
                if(temp.next != null) temp.next.prev = temp.prev;  // borramos temp, por tanto actualizamos el anterior al siguiente
                temp.prev.next = temp.next;                        // borramos temp, por tanto actualizamos el siguiente de la anterior
            }
            size--;
        }
    }
    /**
     * El método coge el hash de la clave la divide en 16 y lo retorna.
     */
    private int getHash(String key) {
        // piggy backing on java string
        // hashcode implementation.
        return key.hashCode() % INITIAL_SIZE;
    }
    /**
     * Esta clase contiene un contructor que guarda el valor y su clave.
     */
    private class HashEntry {
        String key;
        String value;

        // Linked list of same hash entries.
        HashEntry next;
        HashEntry prev;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        /**
         * @return los valores creados y las claves tambíen.
         */
        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    /**
     * @return La tabla creada por los valores y las claves.
     */
    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : entries) {
            if(entry == null) {
                bucket++;
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }

    public ArrayList<String> getCollisionsForKey(String key) {
        return getCollisionsForKey(key, 1);
    }

    /**
     * @param key
     * @param quantity
     * @return
     */
    public ArrayList<String> getCollisionsForKey(String key, int quantity){
        /*
          Main idea:
          alphabet = {0, 1, 2}

          Step 1: "000"
          Step 2: "001"
          Step 3: "002"
          Step 4: "010"
          Step 5: "011"
           ...
          Step N: "222"

          All those keys will be hashed and checking if collides with the given one.
        * */

        final char[] alphabet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        ArrayList<Integer> newKey = new ArrayList();
        ArrayList<String> foundKeys = new ArrayList();

        newKey.add(0);
        int collision = getHash(key);
        int current = newKey.size() -1;

        while (foundKeys.size() < quantity){
            //building current key
            String currentKey = "";
            for(int i = 0; i < newKey.size(); i++)
                currentKey += alphabet[newKey.get(i)];

            if(!currentKey.equals(key) && getHash(currentKey) == collision)
                foundKeys.add(currentKey);

            //increasing the current alphabet key
            newKey.set(current, newKey.get(current)+1);

            //overflow over the alphabet on current!
            if(newKey.get(current) == alphabet.length){
                int previous = current;
                do{
                    //increasing the previous to current alphabet key
                    previous--;
                    if(previous >= 0)  newKey.set(previous, newKey.get(previous) + 1);
                }
                while (previous >= 0 && newKey.get(previous) == alphabet.length);

                //cleaning
                for(int i = previous + 1; i < newKey.size(); i++)
                    newKey.set(i, 0);

                //increasing size on underflow over the key size
                if(previous < 0) newKey.add(0);

                current = newKey.size() -1;
            }
        }
        return  foundKeys;
    }

    /**
     * @param msg Muestra los mensajes creados por el método log.
     */
    public static void log(String msg) {
        System.out.println(msg);
    }
}