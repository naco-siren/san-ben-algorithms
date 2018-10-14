package companies.uber.nested_group_user;

import java.util.*;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        HashMap<String, String[]> MEMBERS_BY_GROUPS = new HashMap<String, String[]>() {{
            put("Group0", new String[]{"Group3", "User0", "User1"});
            put("Group1", new String[]{"Group3", "User2", "User3"});
            put("Group2", new String[]{"Group3", "Group5", "User4", "User5"});
            put("Group3", new String[]{"Group4", "User6", "User7"});
            put("Group4", new String[]{"User8", "User9"});
            put("Group5", new String[]{"User10", "User11"});
        }};

        Solution s1 = new Solution(MEMBERS_BY_GROUPS);
        HashMap<String, String[]> r1 = s1.solve();

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

    Solution(HashMap<String, String[]> membersByGroup) {
        _membersByGroup = membersByGroup;
    }

    private HashMap<String, String[]> _membersByGroup;

    HashMap<String, String[]> solve() {
        HashMap<String, LinkedList<String>> userToGroups = new HashMap<>();
        for (String group : _membersByGroup.keySet()) {
            for (String member : _membersByGroup.get(group)) {
                LinkedList<String> userGroups = userToGroups.computeIfAbsent(member, new Function<String, LinkedList<String>>() {
                    @Override
                    public LinkedList<String> apply(String s) {
                        return new LinkedList<>();
                    }
                });
                userGroups.add(group);
            }
        }

        HashMap<String, String[]> results = new HashMap<>();
        for (String user : userToGroups.keySet()) {
            if (user.startsWith(PREFIX_GROUP))
                continue;

            HashSet<String> result = new HashSet<>();

            LinkedList<String> queue = userToGroups.get(user);
            while (!queue.isEmpty()) {
                String group = queue.poll();
                result.add(group);
                if (userToGroups.containsKey(group))
                    queue.addAll(userToGroups.get(group));
            }

            String[] output = new String[result.size()];
            results.put(user, result.toArray(output));
        }

        return results;
    }
}
