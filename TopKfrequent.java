// the definition of the problem will throw you off
// example: [12, 2,3,2,2,2,1,1,12,1]
// freq: 1 -> 3, 2 -> 4, 3-> 1, 12 -> 2
// if k = 2
// i want the top 2 most frequent elements
// that is 2 and then 1
// if k = 3
// i want top 3 frequent elements
// 2, 1 and then 12 cause frequence of each element is {4,3,2}

// thus we want to know the frequency of each element  -> store in hashmap
// but we want to arrange it by frequency in desc order -> we use min heap and run sorting on frequency {heapify}
// now question says no sorting, so we internal sorting of heap
// remember heap sort does not maintain relative order of elements, but that is not imp here
// heap will give result
// TC: O(k log n) -> where k is the top number of elements we want and then log n to get value from heap
// SC: O(n)

// another way around this is to use Bucket sort
// TC: O(n)
// SC: O(n)

class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
    }

    //PQ
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) ->
      Integer.compare(a.getValue(), b.getValue())
    );
    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      if (pq.size() < k) {
        pq.add(entry);
      } else if (pq.peek().getValue() < entry.getValue()) {
        pq.poll();
        pq.add(entry);
      }
    }
    int[] result = new int[pq.size()];
    while (!pq.isEmpty()) {
      result[pq.size() - 1] = pq.poll().getKey();
    }
    return result;
  }
}

///

class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
    }

    //PQ
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) ->
      Integer.compare(a.getValue(), b.getValue())
    );

    for (Map.Entry<Integer, Integer> map : freqMap.entrySet()) {
      if (pq.size() < k) {
        pq.add(map);
      } else if (pq.peek().getValue() < map.getValue()) {
        pq.poll();
        pq.add(map);
      }
    }

    int[] result = new int[pq.size()];
    while (!pq.isEmpty()) {
      result[pq.size() - 1] = pq.poll().getKey();
    }
    return result;
  }
}
