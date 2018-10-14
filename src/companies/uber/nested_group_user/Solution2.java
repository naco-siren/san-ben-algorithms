package companies.uber.nested_group_user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Function;

public class Solution2 {
    public static void main(String[] args) {
        HashMap<String, String[]> MEMBERS_BY_GROUPS = new HashMap<String, String[]>() {{
            put("Group0", new String[]{"Group3", "User0", "User1"});
            put("Group1", new String[]{"Group3", "User2", "User3"});
            put("Group2", new String[]{"Group3", "Group5", "User4", "User5"});
            put("Group3", new String[]{"Group4", "User6", "User7"});
            put("Group4", new String[]{"User8", "User9"});
            put("Group5", new String[]{"User10", "User11"});
        }};

        Solution2 s1 = new Solution2();
        HashMap<String, String[]> r1 = s1.solve(MEMBERS_BY_GROUPS);

        // Expected output
        HashMap<String, String[]> GROUPS_BY_USERS = new HashMap<String, String[]>() {{
            put("User6", new String[]{"Group1", "Group0", "Group3", "Group2"});
            put("User7", new String[]{"Group1", "Group0", "Group3", "Group2"});
            put("User4", new String[]{"Group2"});
            put("User5", new String[]{"Group2"});
            put("User2", new String[]{"Group1"});
            put("User3", new String[]{"Group1"});
            put("User0", new String[]{"Group0"});
            put("User1", new String[]{"Group0"});
            put("User8", new String[]{"Group4", "Group1", "Group0", "Group3", "Group2"});
            put("User9", new String[]{"Group4", "Group1", "Group0", "Group3", "Group2"});
            put("User10", new String[]{"Group5", "Group2"});
            put("User11", new String[]{"Group5", "Group2"});
        }};
    }

    private static final String PREFIX_GROUP = "Group";
    private static final String PREFIX_USER = "User";

    HashMap<String, String[]> solve(HashMap<String, String[]> membersByGroup) {
        HashMap<String, String> userToGroup = new HashMap<>();
        HashMap<String, LinkedList<String>> groupToGroups = new HashMap<>();

        // Map direct parents
        for (String group : membersByGroup.keySet()) {
            for (String member : membersByGroup.get(group)) {
                // This member can be a user or a group!
                if (member.startsWith(PREFIX_GROUP)) {
                    LinkedList<String> groups = groupToGroups.computeIfAbsent(member, new Function<String, LinkedList<String>>() {
                        @Override
                        public LinkedList<String> apply(String s) {
                            return new LinkedList<>();
                        }
                    });
                    groups.add(group);
                } else {
                    userToGroup.put(member, group);
                }
            }
        }

        // Collapse all nested parents into one layer
        for (String group : groupToGroups.keySet()) {
            HashSet<String> parents = new HashSet<>();
            LinkedList<String> queue = groupToGroups.get(group);
            while (!queue.isEmpty()) {
                String parent = queue.poll();
                parents.add(parent);
                if (groupToGroups.containsKey(parent))
                    queue.addAll(groupToGroups.get(parent));
            }
            queue.addAll(parents);
        }

        // Collect results
        HashMap<String, String[]> results = new HashMap<>();
        for (String user : userToGroup.keySet()) {
            LinkedList<String> result = new LinkedList<>();

            String group = userToGroup.get(user);
            result.add(group);
            if (groupToGroups.containsKey(group))
                result.addAll(groupToGroups.get(group));

            String[] output = new String[result.size()];
            results.put(user, result.toArray(output));
        }

        return results;
    }
}
