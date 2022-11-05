package Tree.structure;

/**
 * @autor yud1
 * @date 2022/11/5 09:51
 * <p>
 * 前缀树：
 * 路径表示字符
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    /**
     * 添加一个字符串
     *
     * @param word
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        //根节点的pass++, 根节点代表以空字符串为前缀的字符串有多少个，即添加的字符串数量
        node.pass++;
        for (int i = 0; i < chars.length; i++) {
            //0：a分支 1：b分支 ....依次类推
            int index = chars[i] - 'a';
            //为null 证明不存在该分支 建立该分支，
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node.nexts[index].pass++;
            node = node.nexts[index];
        }
        node.end++;
    }

    /**
     * 这个字符串加入过几次
     * @return
     */
    public int search(String word){
        if (word == null){
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }



    /**
     * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
     * @return
     */
    public int prefiexNumber(String pre){
        if (pre == null){
            return 0;
        }
        char[] chars = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }


    public void delete(String word){
        //加入过才能删除
        if (search(word)!=0){
            char[] chars = word.toCharArray();
            int index = 0 ;
            TrieNode node = root;
            node.pass--;
            //依次往下寻找
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                //当pass为0时，说明以它为经过的字符串了，则剪去分支
                if (--node.nexts[index].pass == 0){
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

}
