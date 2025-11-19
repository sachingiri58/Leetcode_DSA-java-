class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String directory = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String file = parts[i];
                
                // extract file name and content
                int open = file.indexOf("(");
                int close = file.indexOf(")");

                String fileName = file.substring(0, open);
                String content = file.substring(open + 1, close);

                String fullPath = directory + "/" + fileName;

                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(fullPath);
            }
        }

        // collect only groups with duplicates
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            if (group.size() > 1) {
                result.add(group);
            }
        }

        return result;
    }
}
