
import java.util.*;

public class ipv4{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the ipv4 address");
        String ip = in.next();
        String Broadcastaddress = "";
        String Networkadd="";
        char idc='n';
        String ip1[] = ip.split("\\.");
        int first = Integer.valueOf(ip1[0]);
        if(first > 0  && first < 127){
            System.out.println("Class A");
            Broadcastaddress = ip1[0]+".255.255.255";
            Networkadd = ip1[0]+".0.0.0";
            idc = 'A';
        }
        else if(first > 127  && first < 191){
            System.out.println("Class B");
            Broadcastaddress = ip1[0]+"."+ip1[1]+".255.255";
            Networkadd = ip1[0]+"."+ip1[1]+".0.0";
            idc = 'B';
        }
        else if(first > 191  && first < 223){
            System.out.println("Class C");
            Broadcastaddress = ip1[0]+"."+ip1[1]+"."+ip1[2]+".255";
            Networkadd = ip1[0]+"."+ip1[1]+"."+ip1[2]+".0";
            idc = 'C';
        
        }
        else if(first > 223  && first < 239){
            System.out.println("Class D");
            idc = 'D';
        }
        else if(first > 239  && first < 255){
            System.out.println("Class E");
            idc = 'E';
        }
        else{
            System.out.println("Invalid");

        }

        System.out.println("Broadcast address is "+Broadcastaddress);
        System.out.println("Network address is "+Networkadd);


        System.out.println("Enter the no of subnets");
        int n = in.nextInt();
        int subnet_inc = 256/n;
        int subnet_range[][] = new int[n][2];
        

        for(int i = 0; i < n; i++){
            // subnet_range[i][0] = subnet_inc*i;
            // subnet_range[i][1] = subnet_inc*(i+1)-1;
            // System.out.println("Subnet "+(i+1)+" range is "+subnet_range[i][0]+" to "+subnet_range[i][1]);
            if(idc== 'A'){
               
                subnet_range[i][0] = subnet_inc*i;
                subnet_range[i][1] = subnet_inc*(i+1)-1;
                
                System.out.println("subnet address is "+ip1[0]+"."+subnet_range[i][0]+".0.0");
                System.out.println("Broadcast address is "+ip1[0]+"."+subnet_range[i][1]+".255.255");

                //print full address
                System.out.println("Subnet "+(i+1)+" range is "+ip1[0]+"."+subnet_range[i][0]+"."+0+"."+0+" to "+ip1[0]+"."+subnet_range[i][1]+"."+255+"."+255);
                System.out.println("==========================");
            }
            else if(idc == 'B'){
                subnet_range[i][0] = subnet_inc*i;
                subnet_range[i][1] = subnet_inc*(i+1)-1;
              
                System.out.println("subnet address is "+ip1[0]+"."+ip1[1]+"."+subnet_range[i][0]+".0");
                System.out.println("Broadcast address is "+ip1[0]+"."+ip1[1]+"."+subnet_range[i][1]+".255");
                //print full address
                System.out.println("Subnet "+(i+1)+" range is "+ip1[0]+"."+ip1[1]+"."+subnet_range[i][0]+"."+0+" to "+ip1[0]+"."+ip1[1]+"."+subnet_range[i][1]+"."+255);
                System.out.println("==========================");
            }
            else if(idc =='C'){
                subnet_range[i][0] = subnet_inc*i;
                subnet_range[i][1] = subnet_inc*(i+1)-1;

                System.out.println("subnet address is "+ip1[0]+"."+ip1[1]+"."+ip1[2]+"."+subnet_range[i][0]);
                System.out.println("Broadcast address is "+ip1[0]+"."+ip1[1]+"."+ip1[2]+"."+subnet_range[i][1]);

            
                //print full address
                System.out.println("Subnet "+(i+1)+" range is "+ip1[0]+"."+ip1[1]+"."+ip1[3]+"."+subnet_range[i][0]+" to "+ip1[0]+"."+ip1[1]+"."+ip1[3]+"."+subnet_range[i][1]);
                System.out.println("==========================");
            }
            else{
                System.out.println("Invalid");
            }

        }
        
    }
}
