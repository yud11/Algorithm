package Tree.structure;

/**
 * @autor yud1
 * @date 2022/11/5 09:42
 *
 * 前缀树的节点
 */
public class TrieNode {

    //记录通过的字符串个数
    public int pass;

    //记录以此结尾的字符串个数
    public int end;

    //其下的路径
    public TrieNode[] nexts; // HashMap<Character, TrieNode> nexts;

    public TrieNode() {
        this.pass = 0;
        this.end = 0;
        //nexts[0] == null 表示没有走向a的路径
        //nexts[0] ！= null 表示有走向a的路径
        nexts = new TrieNode[26];
    }
}
