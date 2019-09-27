import java.util.*;

class kMost {

    class Node {
        int freq;
        String str;
        public Node(String str, int freq){
            this.str = str;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> rst = new ArrayList<>();

        // checking user input
        if (words == null || words.length == 0 || k <= 0) {
            return rst;
        }

        //queue
        PriorityQueue<Node> queue = new PriorityQueue<>(k, new Comparator<Node>(){
            public int compare(Node node1, Node node2) {
                if (node1.freq == node2.freq) {
                    return node1.str.compareTo(node2.str);
                } else {
                   // System.out.println(node1.str);
                   // System.out.println(node2.freq - node1.freq );
                    return node2.freq - node1.freq;
                }
            }
        });

        //map
        HashMap<String, Node> map = new HashMap<>();
        for (String word: words) {
            if (! map.containsKey(word)) {
                map.put(word, new Node(word, 0));
            }

            map.get(word).freq = map.get(word).freq + 1;
        }

        for (Map.Entry<String, Node> entry : map.entrySet()) {
            queue.offer(entry.getValue());
        }

        System.out.println(queue.poll().str);
        //output
        for (int i = 0; i < k; i++) {
            rst.add(queue.poll().str);
        }

        return rst;
    }
}