#include<bits/stdc++.h>
using namespace std;
#define int long long
#define ld long double
#define f first
#define s second
#define ar array
#define pb push_back
typedef vector<vector<int>> vvi;
typedef vector<int> vi;  
typedef pair<int,int> pi;
typedef tuple<int,int,int> ti;
int rand(int lb, int ub){
    return (rand() % (ub - lb + 1)) + lb;
}
std::string generateRandomString(int n) {
    std::string randomString;
    randomString.reserve(n);
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<int> dis(0, 25);

    for (int i = 0; i < n; ++i) {
        randomString.push_back('a' + dis(gen));
    }

    return randomString;
}
vector<string> s;
int32_t main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    srand((unsigned) time(NULL));
    cout<<20<<"\n";
    for(int i = 1, j = 0;j < 20; i += 10000, ++j){
        cout<<i<<"\n";
        for(int j = 0; j < i; ++j){
            cout<<generateRandomString(rand(5, 10))<<"\n";
        }
    }
    
}