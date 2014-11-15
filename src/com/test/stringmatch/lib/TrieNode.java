package com.test.stringmatch.lib;

public class TrieNode
{
        private char node;
        private SMap childrens;
        private int value;
        private int prefixValue;
        private boolean isComplete;
        private boolean isPrefix;

        /**
         * Initialize with the default value.
         */
        public TrieNode(char node)
        {
            super();
            this.node = node;
            this.childrens = new SMap();
            this.value = -1;
            this.isComplete = false;
            this.isPrefix = false;
            this.prefixValue = -1;
        }
        /**
         * Initialize with the default value and also accept prefix flag.
         */
        public TrieNode(char node, boolean isPrefix, int prefixValue)
        {
            super();
            this.node = node;
            this.childrens = new SMap();
            this.value = -1;
            this.isComplete = false;
            this.isPrefix = isPrefix;
            this.prefixValue = prefixValue;
        }

        /**
         * Adds a child node into the current tree Node. 
         */
        public void addChild(char node, TrieNode trieNode)
        {
            childrens.put(node, trieNode);
        }

        public SMap getChildrens()
        {
            return childrens;
        }
        public char getNode()
        {
            return node;
        }

        public int getPrefixValue()
        {
            return prefixValue;
        }

        public int getValue()
        {
            return value;
        }

        public boolean isComplete()
        {
            return isComplete;
        }

        public boolean isPrefix()
        {
            return isPrefix;
        }

        public void setChilderns(SMap childerns)
        {
            this.childrens = childerns;
        }

        public void setComplete(boolean isComplete)
        {
            this.isComplete = isComplete;
        }

        public void setNode(char node)
        {
            this.node = node;
        }

        public void setPrefix(boolean isPrefix)
        {
            this.isPrefix = isPrefix;
        }

        public void setPrefixValue(int prefixValue)
        {
            this.prefixValue = prefixValue;
        }

        public void setValue(int value)
        {
            this.value = value;
        }
}
