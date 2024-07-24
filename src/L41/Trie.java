package L41;

public class Trie {
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode getNode() {
        return new TrieNode();
    }

    static void insert(TrieNode root, String key) {
        TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = getNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    static boolean search(TrieNode root, String key) {
        TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    public static void main(String[] args) {
        TrieNode root = getNode();

        insert(root, "hello");
        insert(root, "world");

        System.out.println(search(root, "hello")); // Output: true
        System.out.println(search(root, "world")); // Output: true
        System.out.println(search(root, "hell"));  // Output: false
    }
}
