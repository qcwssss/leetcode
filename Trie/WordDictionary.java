class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root; // dummy
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return helper(word, 0, root);        
    }
    
    private boolean helper(String word, int pos, TrieNode node) {
        if (word.length() == pos) return node.isWord; // reach the end
        char ch = word.charAt(pos);
        if (ch != '.') {
            return node.children[ch - 'a'] != null && 
                helper(word, pos + 1, node.children[ch - 'a']);
        }
        // else '.'
        for (TrieNode t : node.children) {
            if (t != null && helper(word, pos + 1, t)) return true;
        }
        return false;
    }
    
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */