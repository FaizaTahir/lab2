package lab2;


import java.io.*;
import java.util.StringTokenizer;

public class unitcase {

	public static void main(String[] args) {
		
		String fileName = "D:\\test21.txt"; // File To Read
		int i = 0; 
		String varName = null;
		String varValue = null;
		String varName1 =null;
		String[] arr=new String[10];
		int[] temp=new int[10];
		int[] ans=new int[10];
		
		Myclasses object = new Myclasses();			// Variable Object
		
		Myclasses[] Classarray = new Myclasses[8];
		

		String line = null;
		try {
			
			
			
			FileReader fileReader = new FileReader(fileName);

			
			BufferedReader bufferedReader = new BufferedReader(fileReader); 
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("Let")) {
					if (line.contains("=")) {
						String[] position = line.split(" ");
						StringTokenizer st = new StringTokenizer(position[1], "=;");
						while (st.hasMoreTokens()) {
							varName = st.nextToken();
							varValue = st.nextToken();
							
							int ValInt = Integer.parseInt(varValue);
							Classarray[i] = new Myclasses();
							Classarray[i].setName(varName);
							Classarray[i].setValue(ValInt);
							
							//object.setName(varName);
							//object.setValue(ValInt);
							//Classarray[i]=object;
							System.out.println(" " + Classarray[i].getName()+ " "
									+ Classarray[i].getValue());
							//i++;

						}
						
					}//if ends
					else {
						System.out.print("error!");
					}}
				else if (line.contains("+")) {
					
					
					int y=0;
					
					StringTokenizer st2 = new StringTokenizer(line, "=;+-");
					while(st2.hasMoreTokens()) {
					arr[y]=st2.nextToken(); 
					System.out.println(arr[y] +"\t" );
					y++;
					} 
					int tempno=0;
					int check1=0;
					int check2=0;
					for(int l=0;l<y;l++){
						if(arr[l].matches(".*\\d.*")){
							   // contains a number
							temp[tempno]=Integer.parseInt(arr[l]);
							System.out.println(temp[tempno] +"\t" );
							tempno++;
							
							
							
							} else{
							   // does not contain a number
								
							/*	if (Classarray[l].getName()== arr[l] && l==0){
									check1=1;
								}*/
								if (l!=0){
									check2++;
								}
								
								
							}
					}
					int ans1=0;
					for(int x1=0;x1<tempno;x1++){
						ans1+=temp[x1];
					}
					
					for(int x2=1;x2<2;x2++){
						ans1+=Classarray[x2].getValue();
						System.out.println(Classarray[x2].getValue() +"\t" );
					}
					System.out.println("Answer ="+ans1 +"\t" );
					for(int x3=0;x3<2;x3++){
					if (arr[0].equals(Classarray[x3].getName())){
						Classarray[x3].setValue(ans1);
						//System.out.println("printing value is "+Classarray[u].getValue() +"\t" );
					}
					
					}
				} 
				
				
			else if (line.contains("Print")){
				String pvar = null;
				StringTokenizer st3 = new StringTokenizer(line, " ");
				while(st3.hasMoreTokens()) {
					pvar=st3.nextToken(); 
					System.out.println(pvar +"\t" );
					
					} 
				for(int u=0;u<2;u++){
					if (pvar.equals(Classarray[u].getName())){
						System.out.println("printing value is "+Classarray[u].getValue() +"\t" );
					}
					
				}
				}
				i++;
				
			}
			
			
			
			

			
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			
		}
	}
	public void Equating(){
		int operators[]=new int [5];
		
		
	}
}
