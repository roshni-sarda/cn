#include <bits/stdc++.h>
#define sp  ' '
#define ln  '\n'
using namespace std;

int main(void) {
    cout << "Enter number of frames: ";
    int n;
    cin >> n;
    cout << "Enter window size: ";
    int w;
    cin >> w;
    int pos = 0, ack = 0;
    srand(time(NULL));
    
    if(n == w) {        // window size = total frames
        for(int i=0; i<n; i++) {
            cout << "Sending frame " << i << " --->" << ln;
        }
        int lost = rand() % n;
        cout << ln << "No ack for frame " << lost << ln;
        cout << "Retransmitting..." << ln;;
        for(int i=0; i<n; i++) {
            cout << "Sending frame " << i << " --->" << ln;
        }
        return 0;
    }

    while(pos < n) {        // window size < total frames
        if(pos < w) {
            cout << "Sending frame " << pos << " --->" << ln;
            pos++;
        }
        else {
            int sent = rand() % 2;      // generate 0 or 1, 0 == lost and 1 == sent
            if(sent) {
                cout << ln << "Ack for frame " << ack << " <---" << ln;
                cout << "Sending frame " << pos << " ---> " << ln;
                pos++; 
                ack++;
            }
            else {
                cout << ln << "No ack for frame " << ack << ln;
                cout << "Retransmitting..." << ln;;
                pos = ack;
                for(int i=0; i<w; i++) {
                    cout << "Sending frame " << pos + i << " --->" << ln;
                }
                pos = pos + w;  
            }
        }
    }
}