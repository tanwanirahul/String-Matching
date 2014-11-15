package com.test.stringmatch.lib;

/**
 * Our custom implementation of HashMap.
 */
public class SMap
{

    /**
     * Keeping default Map capacity to 16.
     * Since this is for a fairly simple use case, I won't deal with resizing etc.
     */
    static final int DEFAULT_CAPACITY = 16;

    /**
     * Hash table like, holds all the SMap entries.
     */
    private Entry table[];

    /**
     * Holds the state for current SMap capacity.
     */
    private int _capacity = DEFAULT_CAPACITY;

    /**
     * Holds all the Map entries.
     * For my string matching purpose, I know value type is int, and hence not making it a generic type.
     */
    class Entry
    {
        private final String key;
        private int value;
        private Entry next;


        public Entry(String key, int value)
        {
            super();
            this.key = key;
            this.value = value;
        }


        public String getKey()
        {
            return key;
        }


        public Entry getNext()
        {
            return next;
        }


        public int getValue()
        {
            return value;
        }


        public void setNext(Entry next)
        {
            this.next = next;
        }


        public void setValue(int value)
        {
            this.value = value;
        }
    }


    /*
     * Initialize Entry table with default capacity.
     */
    public SMap()
    {
        super();
        table = new Entry[_capacity];
    }


    /*
     * Initialize Entry table with provided capacity.
     */
    public SMap(int capacity)
    {
        super();
        _capacity = capacity;
        table = new Entry[_capacity];
    }


    /**
     * Returns a value for the given key.
     */
    public Entry get(String k)
    {
        int hash = k.hashCode() % get_capacity();
        Entry _entry = table[hash];

        while (_entry != null)
        {
            if (_entry.getKey().equals(k))
            {
                return _entry;
            }
            _entry = _entry.getNext();
        }
        return null;
    }


    /**
     * Allows an insertion into a Map. Given key is mapped to a given value.
     */
    public void put(String k, int v)
    {
        int hash = k.hashCode() % get_capacity();
        Entry _entry = table[hash];

        // Check if the first entry has the same key, if so, update the value.
        if (_entry.getKey().equals(k))
        {
            _entry.setValue(v);
            return;
        }
        // If not, traverse till end. If we find the matching key in the process,
        // update the value else insert it.
        Entry _next = _entry.getNext();

        while (_next != null)
        {
            // Update to new value, if already exist.
            if (_next.getKey().equals(k))
            {
                _next.setValue(v);
                return;
            }
            _entry = _next;
            _next = _next.getNext();
        }

        // Since nowhere we set the value, its a new entry, add it into the list.
        Entry _newEntry = new Entry(k, v);
        _entry.setNext(_newEntry);
    }


    /**
     * Remove a given key from the Map.
     */
    public Entry remove(String k)
    {
        int hash = k.hashCode() % get_capacity();
        Entry _entry = table[hash];

        // Null check. If null, there isn's any entry.
        if (_entry == null)
        {
            return null;
        }

        // Check if the first entry has the same key, if so, update the hashtable directly.
        if (_entry.getKey().equals(k))
        {
            table[hash] = _entry.getNext();
            return _entry;
        }

        // If not, traverse till end. If we find the matching key in the process,
        // update the value else insert it.
        Entry _next = _entry.getNext();

        while (_next != null)
        {
            // If found, move current to next of next.
            if (_next.getKey().equals(k))
            {
                _entry.setNext(_next.getNext());
                return _next;
            }
            _entry = _next;
            _next = _next.getNext();
        }

        // Not found, return null.
        return null;
    }

    /**
     * Only a getter for capacity. I dont want to resize the map once it is constructed.
     */
    public int get_capacity()
    {
        return _capacity;
    }

}
