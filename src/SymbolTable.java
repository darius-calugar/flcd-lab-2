import java.util.Objects;

public class SymbolTable {
    static private final int size = 10;

    private final ListNode[] listHeads;

    SymbolTable() {
        listHeads = new ListNode[size];
    }

    int put(String token) {
        var h    = hash(token);
        var node = listHeads[h];

        if (node == null) {
            listHeads[h] = new ListNode(token, null);
            return h;
        }

        var index = 1;
        while (node.next != null) {
            node = node.next;
            index += 1;
        }

        node.next = new ListNode(token, null);
        return index * size + h;
    }

    String get(int position) {
        var h     = position % size;
        var index = position / size;
        var node  = listHeads[h];
        while (node != null) {
            if (index-- == 0)
                return node.symbol;
            node = node.next;
        }
        return null;
    }

    int lookup(String token) {
        var h     = hash(token);
        var node  = listHeads[h];
        var index = 0;

        while (node != null) {
            if (Objects.equals(node.symbol, token))
                return index * size + h;
            index++;
            node = node.next;
        }
        return -1;
    }

    private int hash(String token) {
        var h = 0;
        for (int i = 0; i < token.length(); i++) {
            h = h * 17 + token.charAt(i);
        }
        return (h > 0 ? h : -h) % size;
    }
}

class ListNode {
    String   symbol;
    ListNode next;

    public ListNode(String token, ListNode next) {
        this.symbol = token;
        this.next   = next;
    }
}