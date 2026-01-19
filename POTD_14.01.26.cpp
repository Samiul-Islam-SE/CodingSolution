class Solution {
  public:
    int catchThieves(vector<char> &arr, int k) {
        // Code here
        queue<int> plc;
        queue<int> t;
        int ans = 0;
        for(int i=0;i<arr.size();i++) {
            if(arr[i]=='P') {
                bool foundAny = false;
                if(!t.empty()) {
                    while(!t.empty() && (t.front()+k)<i) t.pop();
                    if(!t.empty()) {
                        ans++;
                        foundAny = true;
                        t.pop();
                    }
                }
                if(!foundAny) {
                    plc.push(i);
                }
            } else if(arr[i]=='T') {
                bool foundAny = false;
                if(!plc.empty()) {
                    while(!plc.empty() && (plc.front()+k)<i) plc.pop();
                    if(!plc.empty()) {
                        ans++;
                        foundAny = true;
                        plc.pop();
                    }
                }
                if(!foundAny) {
                    t.push(i);
                }
            }
        }
        
        return ans;
    }
};