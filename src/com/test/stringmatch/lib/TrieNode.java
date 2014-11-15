package com.test.stringmatch.lib;

public class TrieNode
{
        private char node;
        private SMap childrens;
        private int value;
        private boolean isComplete;

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
        }

        /**
         * Adds a child node into the current tree Node. 
         */
        public void addChild(char node, TrieNode trieNode)
        {
            childrens.put(node, trieNode);
        }

        public SMap getChilderns()
        {
            return childrens;
        }

        public char getNode()
        {
            return node;
        }

        public int getValue()
        {
            return value;
        }

        public boolean isComplete()
        {
            return isComplete;
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

        public void setValue(int value)
        {
            this.value = value;
        }
}
