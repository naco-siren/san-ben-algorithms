package leetcode.LC_721;

import algorithm.UnionFind;

import java.util.*;

/**
 * 721. Accounts Merge
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 */
class Solution721 {
    public List<List<String>> accountsMergeUnionFind(List<List<String>> accounts) {
        // Initialize two maps from email to name and ID
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToID = new HashMap<>();

        // Construct a union find
        UnionFind unionFind = new UnionFind(1000 * 10 + 1);
        int id = 0;     // ASSIGN EACH EMAIL AN ID!
        for (List<String> account: accounts) {
            String name = null;
            for (String email: account) {
                // Extract the accounts' name
                if (name == null) {
                    name = email;
                    continue;
                }

                // Update two maps
                emailToName.put(email, name);
                if (!emailToID.containsKey(email))
                    emailToID.put(email, id++);

                // Union the current account with the first account of this list
                unionFind.union(
                        emailToID.get(account.get(1)),  // First account is guaranteed to have been assigned an ID
                        emailToID.get(email)
                );
            }
        }

        // Collect union find data into a map of clusters
        Map<Integer, List<String>> ans = new HashMap<>();
        for (String email: emailToName.keySet()) {
            final int rootIdx = unionFind.find(emailToID.get(email));
            ans.computeIfAbsent(rootIdx, x -> new ArrayList<>()).add(email);
        }

        // Collect the cluster map into sorted results
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList<>(ans.values());
    }

    // A different implementation:
    //
    // Time Complexity: O(AlogA), where A=∑ai, s.t. ai is the length of accounts[i].
    // If we used union-by-rank, this complexity improves to O(Aα(A))≈O(A), where \alphaα is the Inverse-Ackermann function.
    //
    // Space Complexity: O(A), the space used by our DSU structure.

    Map<String, Integer> map = new HashMap<>();
    private int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        parent = new int[accounts.size()];
        for (int i = 0; i< parent.length; i++)
            parent[i] = i;

        int parentIndex = 0;
        for (List<String> acc : accounts){
            for (int i = 1, l = acc.size(); i < l; i++){
                Integer v = map.put(acc.get(i), parentIndex);
                if (v != null)
                    union(v, parentIndex);
            }
            parentIndex++;
        }
        List<String>[] userEmails= new ArrayList[accounts.size()];

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int idx = getParent(entry.getValue());
            if (userEmails[idx] == null) {
                userEmails[idx] = new ArrayList<>();
            }
            userEmails[idx].add(entry.getKey());
        }

        for (int i = 0; i < userEmails.length; i++) {
            if (userEmails[i] != null){
                List<String> l = new ArrayList<>();
                l.add(accounts.get(i).get(0));
                Collections.sort(userEmails[i]);
                l.addAll(userEmails[i]);
                res.add(l);
            }
        }
        return res;
    }

    private void union(int v, int j){
        int parentV = getParent(v);
        int parentJ = getParent(j);
        parent[parentJ] = parentV;
    }

    private int getParent(int j){
        int index = j;
        while (j != parent[j]){
            j = parent[j];
        }
        parent[index] = j;
        return j;
    }
}
