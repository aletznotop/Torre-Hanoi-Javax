import java.awt.*;
import java.awt.event.*;


public class TorreHanoiV extends Frame implements ActionListener
{ 
	Button b[] = new Button[100];
	Button btnsolu = new Button("Resolver");
	TextField txtdisco = new TextField(5);
	Label lbldisco = new Label("Ingresa el número de discos (<10):",Label.CENTER);
	int h[] = new int[4];
	int pos[] = new int[4];
	int i,k[] = new int[50];
	int x[] = new int[4];
	int yc;
	int n,xc[]=new int[50];
    public TorreHanoiV() 
    {    	  	 
    	  	 n = 5;
        	 yc = 100;
       		 xc[0] = 100;
       		 for(int f=1;f<50;f++)
       		 	xc[f] = xc[f-1] - 20;
       
	    	try
	    	{
		    	setLayout(null);
		        k[1]=500;
		                  
		         txtdisco.setBounds(400,400,100,25);
		         btnsolu.setBounds(510,400,100,30);
		         lbldisco.setBounds(100,400,290,25);
		         add(lbldisco);
		         add(btnsolu);
		         add(txtdisco);
		         
		         btnsolu.addActionListener(this);
		                     
		         b[0] = new Button(""+0);
		         b[0].setBounds(xc[0], yc, 50, 20);
	         
	        }
	        catch(Exception e)
	        {
	            
	        }
	        setSize(1000,500);
	        setTitle("Torre de Hanoi");
	        setVisible(true);
        
	          addWindowListener(   
	      new java.awt.event.WindowAdapter()   
	      {  
                @Override
	        public void windowClosing( java.awt.event.WindowEvent e )   
	        {  
	          System.exit( 0 );  
	        }  
	      }  
	    );  
    }
    
    public void creaVisual()
    {
    	for(i=1;i<=n;i++)
        {
            k[i] = k[i-1] - 10;
            xc[i] = (300+20+2*k[i])/2;
            b[i] = new Button("Disco "+i);
            b[i].setBackground(Color.BLUE);
            b[i].setBounds(xc[i], b[i-1].getY()+20, 50-2*k[i], 20);
            add(b[i]);
        }
    }
    
    
             @Override
    public void actionPerformed(ActionEvent e) 
    {
    	try{
		    	if(e.getActionCommand().equals("Resolver"))
		    	{
		    	
		    		  n = Integer.parseInt(txtdisco.getText());
		    		 x[1] = 000;
		         	 x[2] = 300;
		        	 x[3] = 600;
			    	 h[1] = 0;
			         h[2] = h[3] = (n)*20;
		    		
		    	     creaVisual();
		    		 tower(n,1,2,3);
		    		 Thread.sleep(500);
		    		 for(i=0;i<=n;i++)
		    		 	this.remove(b[i]);
                                 this.txtdisco.setText("");
		    	}
    		
    	}
    	catch(NumberFormatException | InterruptedException f){   	}
    }
    
   
    
    public static void main(String[] args) 
    {
    	TorreHanoiV a = new TorreHanoiV();
    }
    public void tower(int top,int torreA,int torreB,int torreC) throws InterruptedException
    {
         if (top == 1){
        // verifico que todo corra bien
     	//System.out.println("Disco "+top+" de " + torreA + " para " + torreC);
     		
    	Thread.sleep(500);
            b[top].setLocation(xc[top]+x[torreC],yc+h[torreC]);
            h[torreC]-=20;
            h[torreA]+=20;
    	}
    else{
      tower(top - 1, torreA, torreC, torreB);
      // verifico que todo corra bien
      //System.out.println("Disco "+top+" de " + torreA + " para " + torreC);
    	Thread.sleep(500);

      	b[top].setLocation(xc[top]+x[torreC],yc+h[torreC]);
      	h[torreC]-=20;
     	h[torreA]+=20;
        tower(top - 1, torreB, torreA, torreC);
      // verifico que todo corra bien
      //System.out.println("Disco "+top+" de " + torreA + " para " + torreC);
    }
  
    }
}
