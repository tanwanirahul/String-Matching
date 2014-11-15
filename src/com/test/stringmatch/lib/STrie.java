package com.test.stringmatch.lib;

/**
 * Our custom implementation of Trie.
 */
public class STrie
{
    private TrieNode root;


    public STrie()
    {
        super();
        // Initialize the Trie root with \0.
        root = new TrieNode((char) 0);
    }


    /**
     * Adds a given string value into a Trie.
     */
    public void add(String value, int id)
    {
        TrieNode tree = root;

        for (char ch : value.toCharArray())
        {
            SMap child = tree.getChildrens();

            TrieNode _next = child.get(ch);
            if (_next != null)
            {
                tree = _next;
            }
            else
            {
                TrieNode temp = new TrieNode(ch);
                tree.addChild(ch, temp);
                tree = temp;
            }
        }

        tree.setComplete(true);
        tree.setValue(id);
    }


    /**
     * Adds a given string value into a Trie.
     */
    public void addPrefix(String value, int id)
    {
        TrieNode tree = root;

        for (char ch : value.toCharArray())
        {
            SMap child = tree.getChildrens();

            TrieNode _next = child.get(ch);
            if (_next != null)
            {
                tree = _next;
                if (!tree.isPrefix())
                {
                    tree.setPrefix(true);
                    tree.setPrefixValue(id);
                }
            }
            else
            {
                TrieNode temp = new TrieNode(ch, true, id);
                tree.addChild(ch, temp);
                tree = temp;
            }
        }
        tree.setComplete(true);
    }
    

    /**
     * For a given string, find a longest prefix match.
     */
    public int getLongestPrefixValue(String value)
    {
        int match = -1;

        TrieNode tree = root;

        // Keep traversing the tree till all the input characters are matching.
        for (char ch : value.toCharArray())
        {
            SMap child = tree.getChildrens();

            TrieNode _next = child.get(ch);
            if (_next != null)
            {
                tree = _next;

                if (tree.isPrefix())
                {
                    match = tree.getPrefixValue();
                }
            }
        }
        return match;
    }


    /**
     * For a given string, returns the value of the exact match.
     */
    public int getExactStringValue(String value)
    {
        int match = -1;

        TrieNode tree = root;

        // Keep traversing the tree till all the input characters are matching.
        for (char ch : value.toCharArray())
        {
            SMap child = tree.getChildrens();

            TrieNode _next = child.get(ch);
            if (_next != null)
            {
                tree = _next;
            }
            else
            {
                return match;
            }
        }
        match = tree.isComplete() ? tree.getValue() : match;
        return match;
    }

    /**
     * Look for a given string to find the corresponding value.
     */
    public int lookup(String value)
    {
        int match = -1;

        // Check for a exact match first.
        match = getExactStringValue(value);

        // If no exact match, find if the prefix match?
        if (match == -1)
            match = getLongestPrefixValue(value);

        return match;
    }

    /**
     * Removes exact word.
     */
    public boolean removeComplete(String value)
    {
        boolean result = false;

        TrieNode tree = root;

        // Keep traversing the tree till all the input characters are matching.
        for (char ch : value.toCharArray())
        {
            SMap child = tree.getChildrens();

            TrieNode _next = child.get(ch);
            if (_next != null)
            {
                tree = _next;
            }
            else
            {
                return false;
            }
        }

        result = tree.isComplete() == true;
        tree.setComplete(false);
        tree.setValue(-1);
        return result;
    }

    /**
     * Removes prefix word.
     */
    public boolean removePrefix(String value)
    {
        boolean result = true;

        TrieNode tree = root;

        // Keep traversing the tree till all the input characters are matching.
        for (char ch : value.toCharArray())
        {
            SMap child = tree.getChildrens();

            TrieNode _next = child.get(ch);
            if (_next != null)
            {
                tree = _next;
                result = result & tree.isPrefix() == true;
                tree.setPrefix(false);
                tree.setPrefixValue(-1);
            }
            else
            {
                return false;
            }
        }
        result = result & tree.isComplete() == true;
        tree.setComplete(false);
        return result;
    }

}
