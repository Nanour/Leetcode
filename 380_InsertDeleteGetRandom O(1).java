// Sourse : https://leetcode.com/problems/insert-delete-getrandom-o1/
// Date   : 2016-12-29

/***********************************************************************
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * 
 ***********************************************************************/

public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locations;     // <number, locations in list>
    java.util.Random rand = new java.util.Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locations = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locations.containsKey(val)) {
            return false;
        }
        locations.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) {
            return false;
        }
        int currLocation = locations.get(val);
        if (currLocation < nums.size()-1) {
            int lastone = nums.get(nums.size()-1);
            locations.put(lastone, currLocation);
            nums.set(currLocation, lastone);
        }
        locations.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */