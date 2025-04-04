class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int ans = 0;
        for(int[] box : boxTypes)
        {
		
            if(box[0] <= truckSize)
            {
                ans += box[1] * box[0];
                truckSize -= box[0];
            }
		
            else
            {
                ans += box[1] * truckSize;
                return ans;
            }
        }
        return ans;
    }
}