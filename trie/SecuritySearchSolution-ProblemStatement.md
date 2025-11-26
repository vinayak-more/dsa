Problem Statement: 
## Security Search Solution

### Problem Statement

You are given a list of securities, each represented as a string of uppercase English letters (`A-Z`) calles Symbol and a mixed case Name. Your task is to efficiently perform prefix searches on this list.

For each query, you will be given a prefix, and you must return all security codes from the list for which name or symbol start with this prefix, in lexicographical order.

Problem Code:
```java
import java.util.*;

class Security {

    String name;
    String symbol;

    public Security(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}

class SecuritySearch {

    public SecuritySearch(List<Security> securities) {
    }

    public List<Security> searchByPrefix(String prefix) {
        return Collections.emptyList();
    }
}


public class SecuritySearchSolution {

    public static void main(String[] args) {
        List<Security> securities = Arrays.asList(
                new Security("Apple Inc.", "AAPL"),
                new Security("Amazon.com, Inc.", "AMZN"),
                new Security("Alphabet Inc.", "GOOGL"),
                new Security("Microsoft Corporation", "MSFT")
        );

        SecuritySearch securitySearch = new SecuritySearch(securities);

        List<Security> results1 = securitySearch.searchByPrefix("A");
        System.out.println("Search results for prefix 'A':");
        for (Security sec : results1) {
            System.out.println(sec.name + " (" + sec.symbol + ")");
        }

        List<Security> results2 = securitySearch.searchByPrefix("Go");
        System.out.println("\nSearch results for prefix 'Go':");
        for (Security sec : results2) {
            System.out.println(sec.name + " (" + sec.symbol + ")");
        }

        List<Security> results3 = securitySearch.searchByPrefix("M");
        System.out.println("\nSearch results for prefix 'M':");
        for (Security sec : results3) {
            System.out.println(sec.name + " (" + sec.symbol + ")");
        }
    }
}
```

Solution
```java
import java.util.*;

class Security {

    String name;
    String symbol;

    public Security(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}

class SecuritySearch {

    private PrefixTree prefixTree;

    public SecuritySearch(List<Security> securities) {
        prefixTree = new PrefixTree();

        for (Security sec : securities) {
            prefixTree.insert(sec.name.toLowerCase(), sec);
            prefixTree.insert(sec.symbol.toLowerCase(), sec);
        }
    }

    public List<Security> searchByPrefix(String prefix) {
        prefix = prefix.toLowerCase();
        return prefixTree.startsWith(prefix);
    }
}

class PrefixTree {

    private class TrieNode {

        Map<Character, TrieNode> children;
        Set<Security> securities;

        public TrieNode() {
            children = new HashMap<>();
            securities = new HashSet<>();
        }
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String key, Security security) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.securities.add(security);
        }
    }

    public List<Security> startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return new ArrayList<>();
            }
            node = node.children.get(ch);
        }
        return new ArrayList<>(node.securities);
    }
}

public class SecuritySearchSolution {

    public static void main(String[] args) {
        List<Security> securities = Arrays.asList(
                new Security("Apple Inc.", "AAPL"),
                new Security("Amazon.com, Inc.", "AMZN"),
                new Security("Alphabet Inc.", "GOOGL"),
                new Security("Microsoft Corporation", "MSFT")
        );

        SecuritySearch securitySearch = new SecuritySearch(securities);

        List<Security> results1 = securitySearch.searchByPrefix("A");
        System.out.println("Search results for prefix 'A':");
        for (Security sec : results1) {
            System.out.println(sec.name + " (" + sec.symbol + ")");
        }

        List<Security> results2 = securitySearch.searchByPrefix("Go");
        System.out.println("\nSearch results for prefix 'Go':");
        for (Security sec : results2) {
            System.out.println(sec.name + " (" + sec.symbol + ")");
        }

        List<Security> results3 = securitySearch.searchByPrefix("M");
        System.out.println("\nSearch results for prefix 'M':");
        for (Security sec : results3) {
            System.out.println(sec.name + " (" + sec.symbol + ")");
        }
    }
}
```