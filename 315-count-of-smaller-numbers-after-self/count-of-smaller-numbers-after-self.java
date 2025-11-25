class Solution {
    private int[] indexes;
    private int[] counts;
    private int[] temp;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        indexes = new int[n];
        counts = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : counts) result.add(c);
        return result;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (nums[indexes[i]] <= nums[indexes[j]]) {
                temp[k] = indexes[i];
                counts[indexes[i]] += (j - (mid + 1));
                i++;
            } else {
                temp[k] = indexes[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = indexes[i];
            counts[indexes[i]] += (j - (mid + 1));
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = indexes[j];
            j++;
            k++;
        }

        for (int p = left; p <= right; p++) {
            indexes[p] = temp[p];
        }
    }
}
