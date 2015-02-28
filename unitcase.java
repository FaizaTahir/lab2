package lab2;


import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class unitcase {

	public static void main(String[] args) {
		
		String fileName = "D:\\test21.txt"; // File To Read
		int i = 0; 
		String varName = null;
		String varValue = null;
		
		int mcounter=0;
		
	
		
		Myclasses[] Classarray = new Myclasses[8];
		

		String line = null;
		try {
			
			
			
			FileReader fileReader = new FileReader(fileName);

			
			BufferedReader bufferedReader = new BufferedReader(fileReader); 
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("Let")) {
					if (line.contains("=")) {
						mcounter++;
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
				else if (line.contains("+")||line.contains("-")||line.contains("/")||line.contains("*")) {
					
					
					
					
					
					Scanner scan = new Scanner(System.in);

			        /* Create stacks for operators and operands */

			        Stack<Integer> op  = new Stack<Integer>();

			        Stack<Double> val = new Stack<Double>();

			        /* Create temporary stacks for operators and operands */

			        Stack<Integer> optmp  = new Stack<Integer>();

			        Stack<Double> valtmp = new Stack<Double>();

			        /* Accept expression */

			        System.out.println("Evaluation Of Arithmetic Expression Using Stacks Test\n");

			       
			        String[] parts = line.split("=");
			        String string1 = parts[0]; // 004
			        String string2 = parts[1]; // 034556

			        String input = line;
			        input=string2;
			        

			        //input = "0" + input;

			        input = input.replaceAll("-","+-");
			        System.out.println("EQ:  "+ string1 +" = "+ string2);   

			        /* Store operands and operators in respective stacks */

			        String temp = "";

			        for (int ii = 0;ii < input.length();ii++)

			        {

			            char ch = input.charAt(ii);
			          
			            if( Character.isLetter(ch)){
				        	   String mch=Character.toString(ch);
				        	 //  System.out.println("test11"+mch );
				        	   
				        	   for(int x3=0;x3<mcounter;x3++){
									if (mch.equals(Classarray[x3].getName())){
										//System.out.println("test22"+ Classarray[x3].getValue() );
										//ch=Classarray[x3].getValue();
										ch=Character.forDigit(Classarray[x3].getValue(), 10);
										//System.out.println("test"+ch );
									}
									
									}
				        	   
				        	   
				           }//if   	
			            
			          
			           

			            if (ch == '-')

			                temp = "-" + temp;

			            else if (ch != '+' &&  ch != '*' && ch != '/')

			               temp = temp + ch;

			            else

			            {
			            	
			            
			            	//System.out.println(temp); System.out.println(ch);     

			                val.push(Double.parseDouble(temp));

			                op.push((int)ch);

			                temp = "";

			            }

			        }

			        val.push(Double.parseDouble(temp));

			        /* Create char array of operators as per precedence */

			        /* -ve sign is already taken care of while storing */

			        char operators[] = {'/','*','+'};

			        /* Evaluation of expression */

			        for (int  ii = 0; ii < 3; ii++)

			        {

			            boolean it = false;

			            while (!op.isEmpty())

			            {

			                int optr = op.pop();

			                double v1 = val.pop();

			                double v2 = val.pop();

			                if (optr == operators[ii])

			                {

			                    /* if operator matches evaluate and store in temporary stack */

			                    if (ii == 0)

			                    {

			                        valtmp.push(v2 / v1);

			                        it = true;

			                        break;

			                    }

			                    else if (ii == 1)

			                    {

			                        valtmp.push(v2 * v1);

			                        it = true;

			                        break;

			                    }

			                    else if (ii == 2)

			                    {

			                        valtmp.push(v2 + v1);

			                        it = true;

			                        break;

			                    }                                        

			                }

			                else

			                {

			                    valtmp.push(v1);

			                    val.push(v2);

			                    optmp.push(optr);

			                }                

			            }    

			            /* Push back all elements from temporary stacks to main stacks */            

			            while (!valtmp.isEmpty())

			                val.push(valtmp.pop());

			            while (!optmp.isEmpty())

			                op.push(optmp.pop());

			            /* Iterate again for same operator */

			            if (it)

			                ii--;                            

			        }  
			        
			      int  result= (val.pop()).intValue();

			        System.out.println("Result = "+result);     
					
					
					
					
					
					
					
					int err=0;
			        for(int x3=0;x3<mcounter;x3++){
						if (string1.equals(Classarray[x3].getName())){
							Classarray[x3].setValue(result);
							err=1;
							//System.out.println("printing value is "+Classarray[u].getValue() +"\t" );
						}
						
						}
					
			        if(err == 0){
						System.out.println("Variabe not defined");
						 System.exit(0);
					}
					
					
					
					
					
					
					
					
					
				} 
				
				
			else if (line.contains("Print")){
				System.out.println(line);
				String pvar = null;
				StringTokenizer st3 = new StringTokenizer(line, " ");
				while(st3.hasMoreTokens()) {
					pvar=st3.nextToken(); 
					//System.out.println(pvar +"\t" );
					
					} 
				for(int u=0;u<mcounter;u++){
					
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
	
}
