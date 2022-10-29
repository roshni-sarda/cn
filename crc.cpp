#include <bits/stdc++.h>
using namespace std;

string xor_strings(string a, string b){
    string res = "";
    for(int i=0;i<a.size();i++){
        res += (((a[i]-'0') ^ (b[i]-'0')) + '0');
    }
    return res;
}

int find_leading_index(string temp){
    for(int i=0;i<temp.size();i++){
        if(temp[i]=='1'){
            return i;
        }
    }
    return -1;
}

string calc_crc(string msg, string crc_div){
    string crc;
    int L = crc_div.size();
    for(int i=0;i<L-1;i++){
        msg += '0';
    }
    int i = L-1;
    int lead_index = L;
    string temp1 = msg.substr(0,L);
    while(i<msg.size()){
        // cout<<"i:"<<i<<" crc:"<<crc<<" temp1:"<<temp1<<"\n";
        crc = xor_strings(temp1,crc_div);
        lead_index = find_leading_index(crc);
        temp1 = crc.substr(lead_index) + msg.substr(i+1,lead_index);
        i += lead_index;
    }
    // cout<<"i:"<<i<<" crc:"<<crc<<" temp1:"<<temp1<<"\n";
    crc += temp1.substr(1);
    crc = crc.substr(crc.size()-L+1);
    return crc;
}

bool check_msg(string full_msg, string crc_div){
    int L = crc_div.size();
    string msg = full_msg.substr(0,full_msg.size()-L+1);
    string crc = full_msg.substr(full_msg.size()-L+1);
    // cout<<"Message:"<<msg<<" CRC:"<<crc;
    string crc2 = calc_crc(msg,crc_div);
    return crc.compare(crc2) == 0;
}

int main(){
    string msg,crc_div;
    cout<<"Enter message bits\n";
    cin>>msg;
    cout<<"Enter CRC Divisor\n";
    cin>>crc_div;

    string crc;
    crc = calc_crc(msg,crc_div);
    cout<<"CRC:"<<crc<<"\n";
    string full_msg = msg+crc;
    cout<<"Full message received by user:"<<full_msg<<"\n\n";
    
    //introducing error
    int err_bit;
    cout<<"Which bit (index) do you want to change?"<<"\n";
    cin>>err_bit;
    if(full_msg[err_bit]=='0'){
        full_msg[err_bit]='1';
    }else{
        full_msg[err_bit]='0';
    }
    cout<<"Message received:"<<full_msg<<"\n";
    bool is_valid = check_msg(full_msg,crc_div);
    if(is_valid){
        cout<<"Valid message";
    }else{
        cout<<"Invalid message";
    }
}