package top.panson.top100.graph;

/**
 * @author Panson
 * @create 2025-07-06
 *
 */
public class L208 {
    class Trie {
        private TrieNode root;

        // 节点类
        static class TrieNode {
            TrieNode[] children = new TrieNode[26];  // a-z
            boolean isEnd = false;                   // 是否为单词结尾
        }

        public Trie() {
            root = new TrieNode();
        }

        // 插入
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        // 查找完整单词
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        // 查找前缀
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        // 辅助方法：查找前缀
        private TrieNode searchPrefix(String str) {
            TrieNode node = root;
            for (char c : str.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) return null;
                node = node.children[idx];
            }
            return node;
        }
    }

}
