class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;      // net gas overall
        int tank = 0;       // current gas in tank
        int start = 0;      // starting index

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

           
            if (tank < 0) {
                start = i + 1;  // choose next station
                tank = 0;       // reset tank
            }
        }

        
        return total >= 0 ? start : -1;
    }
}
