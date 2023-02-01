import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class App implements ActionListener {
        int count = 0;
        int y = 0;
        JLabel label, label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label17,label13,label14,label15,label16;
        JButton  button, button2, button3,button4,button7,closebutton,button6,closebutton2, closebutton3;
        JPanel panel, panel2, panel3,panel4;
        JFrame frame, frame2,frame3, frame4;
        JTextField text,text2;    
        double amount;
        double doubleprice=0;
        double runningtotal;
        double finalp =amount*doubleprice;
        String cartstring,cartstring2;
        String [] yourcart,yourcart2;
        List<String> cart = new ArrayList<>();
        
        List<String> cart2 = new ArrayList<>();
    public App() {
        
        frame = new JFrame();
        panel = new JPanel();
        panel3 = new JPanel();
        button = new JButton("Find Item #1");
        button2 = new JButton("Purchase item #1");
        button3 = new JButton("View Current Order");
        button4 = new JButton("checkout");
        button6 = new JButton("exit");
        
        button7 = new JButton("New order");
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button7.addActionListener(this);
        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        
        button6.addActionListener(this);


        label = new JLabel(" ");

        label2 = new JLabel("Enter quntity for Item #1");
        
        
        label3 = new JLabel("Details for Item #1");
        label4 = new JLabel("Order Subtotal for "+(0)+ " item(s)");
        label5 = new JLabel("Enter Item ID for Item #1");
        label6 = new JLabel("0");
        panel.setBorder(BorderFactory.createEmptyBorder(300,200,40,300));
        panel.setLayout(new GridLayout(0,2));
        //panel3.setBorder(BorderFactory.createEmptyBorder(200,500,40,500));
       // panel3.setLayout(new GridLayout(0,2));
       panel3.setLayout(null);
        panel3.setBounds(0,0,1500,750);
        button.setBounds(300,350,150,20);  //find item
        button2.setBounds(500,350,150,20); // purchouse item

        button3.setBounds(300,400,150,20);//current order
        
        button4.setBounds(500,400,150,20);// checout
        
        button7.setBounds(300,450,150,20);//new order
        button6.setBounds(500,450,150,20);//exit
        
        text = new JTextField(0);
        text2 = new JTextField(0);
        //label.setPreferredSize(new Dimension(200, 25));
        
        text.setBounds(500,150,100,20);
        text2.setBounds(500,200,100,20);
        label.setBounds(500,250,500,20);
       
        label2.setBounds(320,200,300,20);
        
        label3.setBounds(320,250,300,20);
        label4.setBounds(320,300,300,20);
        
        label5.setBounds(320,150,300,20);
        
        label6.setBounds(500,300,300,20);
        panel3.add(label);
        panel3.add(text);
        
        panel3.add(label2);
        panel3.add(text2);
        panel3.add(button);
        panel3.add(button2);
        panel3.add(button3);
        panel3.add(button4);
        panel3.add(label3);
        
        panel3.add(label5);
        
        panel3.add(label6);
        panel3.add(label4);
        panel3.add(button7);
        panel3.add(button6);
     
       frame.setSize(1000,800);
        frame.add(panel3, BorderLayout.CENTER);
        frame.setLayout(null);
        //frame.add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Nile dot come spring 2023");
       // frame.pack();
        frame.setVisible(true);


    }
    public static void main(String[] args) {
      //  System.out.println("Hello, World! bitches");
        new App();
    }
   



    public void actionPerformed(ActionEvent evt) { 
        int check=0;
        if (evt.getSource()==button) { //do something 
            count ++;
        label.setText("num clicks" + count);
        String x = text.getText();
        
        int trigger = 0;

       System.out.println(x);
       Scanner input;
       
    try {
        //String newline = System.getProperty("line.separator");
        int page1=0;
        String[] price;
        input = new Scanner(new File("src/inventory.txt"));
        //String newline1="\r?\n";
        
        button2.setEnabled(true);
        while (input.hasNextLine()) {
            String search = input.nextLine();
            //System.out.println("SEARCH CONTENT:"+search);
            page1++ ; 
            if (search.toUpperCase().contains(x+",")) {
                check = 1;
                System.out.println("Found: " +search +" line number"+ page1);
                trigger=1;
                button.setEnabled(false);
                
                cartstring=search;
                price = search.split(",", 6);  
            
                System.out.println("price: " +price[3] );
                doubleprice = Double.parseDouble(price[3] ); 
                System.out.println("double price: " +doubleprice );
                
                amount =0;
                String y = text2.getText();
            if(y.isEmpty()){
                y="0";
            }
                amount = Double.parseDouble(y); 
                int percent=0;
            
                double multpercent = 0;
                if(amount<5){
                    percent = 0;
                }
                if(amount<9 && amount>5){
                    percent = 5;
                    multpercent = .05;
                }
                if(amount<14 && amount>10){
                    percent = 10;
                    multpercent =.1;
                }if(amount>14){
                    percent = 20;
                    
                    multpercent =.2;
                }
                double finallbut1=0;
                finallbut1= amount * doubleprice * (1-multpercent);

                label.setText(search +" "+ amount+ " "+ percent+" "+finallbut1);
                finallbut1=runningtotal+finallbut1;
            label6.setText(""+String.format("%.2f",finallbut1));
                if(price[2].contentEquals(" false")){

                    System.out.println("out of stock");
                    frame2 = new JFrame();
                    panel = new JPanel();
                    closebutton = new JButton("ok");
                   
                    closebutton.addActionListener(this);
                    button2.setEnabled(false);
                  
            
                    label16 = new JLabel("Item is out of stock");
                    panel.setBorder(BorderFactory.createEmptyBorder(200,200,40,100));
                    panel.setLayout(new GridLayout(2,6));
                    closebutton.setBounds(100,200,500,200);
            
                    
                    
                    panel.add(closebutton);
                    panel.add(label16);
                    frame2.add(panel, BorderLayout.CENTER);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setTitle("Nile Dot Com - ERROR");
                    frame2.pack();
                    frame2.setVisible(true);

                }
            } 
            if ((search.toUpperCase().contains(x+",")==false && check ==0)){
                String itemnot= "item not found";
                label.setText(itemnot);
                
            }
            

        }
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    if(trigger==0){
        System.out.println("out of stock");
        frame2 = new JFrame();
        panel = new JPanel();
        closebutton = new JButton("ok");
       
        closebutton.addActionListener(this);
        button2.setEnabled(false);

        label17 = new JLabel("Item not found");
        panel.setBorder(BorderFactory.createEmptyBorder(200,200,40,100));
        panel.setLayout(new GridLayout(2,6));
        closebutton.setBounds(100,200,500,200);

        
        
        panel.add(closebutton);
        panel.add(label17);
        frame2.add(panel, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Nile Dot Com - ERROR");
        frame2.pack();
        frame2.setVisible(true);
        trigger=0;
        
    }
        }
        else if (evt.getSource()==button2) {
            
            button4.setEnabled(true);
            button3.setEnabled(true);
            DateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm:ss aa");
            DateFormat df2 = new SimpleDateFormat("ddMMyyyyHHmm");
            Date dateobj = new Date();
            System.out.println(df.format(dateobj));
            String todayAsString = df2.format(dateobj);
            
            String todayAsString2 = df.format(dateobj);
            System.out.println(todayAsString);
            String y = text2.getText();
            amount = Double.parseDouble(y); 
            System.out.println("double price: " +amount );
            
            
            System.out.println("double price: " + finalp);
            System.out.println("this is car string" +cartstring );
            
            
            int percent=0;
            
            double multpercent = 0;
            if(amount<5){
                percent = 0;
            }
            if(amount<9 && amount>5){
                percent = 5;
                multpercent = .05;
            }
            if(amount<14 && amount>10){
                percent = 10;
                multpercent =.1;
            }if(amount>14){
                percent = 20;
                
                multpercent =.2;
            }
            finalp =amount*doubleprice;
            finalp = finalp*(1-multpercent);
            //label.setText(cart[] +" "+ amount +" "+ percent + "%"+ finalp);
            
            cartstring2 = cartstring + ", "+ amount+ ", " + percent + "%, "+ finalp;
            cartstring = todayAsString+", "+ cartstring + ", "+ amount+ ", " + percent + "%, "+ finalp + ", " + todayAsString2 + " est";
            
            System.out.println(cartstring);
            cart.add(cartstring);
            
            cart2.add(cartstring2);
            y=y+1;
            
            label.setText(cartstring2);
            System.out.println("this is the list new shit                                   " +cartstring );
            cart.forEach(System.out::println);
            runningtotal=runningtotal+finalp;
            amount=0;
            percent=0;
            finalp=0;
           int items = cart.size();
           cartstring = null;
           cartstring2 = null;
        System.out.println("Size of list = " + items+1);
        
        label3.setText("Details for Item #" + (items+1));

        label5.setText("Enter Item ID for Item #" + (items+1));
        
        label2.setText("Enter quntity for Item #"+(items+1));
        
        label6.setText(""+String.format("%.2f",runningtotal));
        
        label4.setText("Order Subtotal for "+(items)+ " item(s)");
        
        button.setText("Find Item #"+(items+1));
        
        button2.setText("Purchase item #"+(items+1));
        button2.setEnabled(false);
        button.setEnabled(true);

        
        System.out.println("out of stock");
        frame2 = new JFrame();
        panel = new JPanel();
        closebutton = new JButton("ok");
       
        closebutton.addActionListener(this);
       
        label15 = new JLabel("Item #"+items+" accepted. Added to your cart.");
        panel.setBorder(BorderFactory.createEmptyBorder(200,200,40,100));
        panel.setLayout(new GridLayout(2,6));
        closebutton.setBounds(100,200,500,200);

        
        
        panel.add(closebutton);
        panel.add(label15);
        frame2.add(panel, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Nile Dot Com - Item Confirmed");
        frame2.pack();
        frame2.setVisible(true);

        }
        else if (evt.getSource()==button3) {
           

          

            System.out.println(cart);
            
               frame3 = new JFrame();
                    panel = new JPanel();
                    panel2 = new JPanel();
                    closebutton2 = new JButton("ok");
                    closebutton2.addActionListener(this);
            
                   
                    //label = new JLabel(outstring);
                    JTextArea coolbigstring= new JTextArea();
                    String outstring =cart.toString(); 
            for (String s : cart) {
                coolbigstring.append(s.toString() + "\n"); // New line at the end
            }
            System.out.println(outstring);
                    panel.setBorder(BorderFactory.createEmptyBorder(200,200,40,100));
                    panel.setLayout(new GridLayout(10,1));
                    panel2.setBorder(BorderFactory.createEmptyBorder(40,50,40,50));
                    panel2.setLayout(new BorderLayout());
                    closebutton2.setBounds(50,20,50,50);
                    
                    panel.add(coolbigstring);
                    panel2.add(closebutton2);
                    
                    frame3.add(panel, BorderLayout.NORTH);  
                    frame3.add(panel2, BorderLayout.SOUTH);  
                    frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame3.setTitle("nile dot come Current Shopping Cart Status");
                    frame3.pack();
                    frame3.setVisible(true);
                 
        }
        
        else if (evt.getSource()==button4) {
            

 try {
 
                File myFile = new File("transaction.txt");
              
                if (myFile.createNewFile()){
                    StringBuffer text = new StringBuffer();
                    for (String mark: cart) {
                    text.append(mark.toString()).append('\n');
                    }

                 System.out.println("File is created!");
                 try (FileWriter f = new FileWriter("transaction.txt", true); 
                 BufferedWriter b = new BufferedWriter(f); 
                 PrintWriter p = new PrintWriter(b);) { 
                    p.println(text); 
                } catch (IOException i) { 
                    i.printStackTrace(); 
                }
                }else{
                    StringBuffer text = new StringBuffer();
                    for (String mark: cart) {
                    text.append(mark.toString()).append('\n');
                    }
                 System.out.println("File already exists.");
                 
                 System.out.println(text);
                 try (FileWriter f = new FileWriter("transaction.txt", true); 
                 BufferedWriter b = new BufferedWriter(f); 
                 PrintWriter p = new PrintWriter(b);) { 
                    p.println(text); 
                } catch (IOException i) { 
                    i.printStackTrace(); 
                }
                }
              
               } catch (IOException e) {
                e.printStackTrace();
               }


            DateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm:ss aa");
            DateFormat df2 = new SimpleDateFormat("ddMMyyyyHHmm");
            Date dateobj = new Date();
            System.out.println(df.format(dateobj));
            String todayAsString = df2.format(dateobj);
            
            String todayAsString2 = df.format(dateobj);
            System.out.println(todayAsString);
               frame4 = new JFrame();
               
               panel4 = new JPanel();
               
               closebutton2 = new JButton("ok");

               int items = cart.size();
               label7 = new JLabel(todayAsString2);
               label8 = new JLabel("Number of line items " + items);
               label9 = new JLabel("");
               JTextArea coolbigstring= new JTextArea();
               label10 = new JLabel("Order Subtotal:" + String.format("%.2f",runningtotal));
               label11 = new JLabel("Tax Rate:      6");
               double totawtax = runningtotal * 1.06;
               double taxamount = totawtax-runningtotal;
               label12 = new JLabel("Tax amount:      "+String.format("%.2f",taxamount));
               label13 = new JLabel("Order Total      " + String.format("%.2f", totawtax));
               label14 = new JLabel("Thanks for shopping at Nile Dot Com!");
               String outstring =cart2.toString(); 
       for (String s : cart2) {
           coolbigstring.append(s.toString() + "\n"); // New line at the end
       }
                
       closebutton3 = new JButton("ok");
               closebutton3.addActionListener(this);

        
               closebutton3.setBounds(50,20,50,50);
               
               panel4.setLayout(null);
               
        panel4.setBounds(0,0,1500,750);
        label7.setBounds(300,70,200,20);
        label8.setBounds(300,150,200,20);
        coolbigstring.setBounds(300,200,500,200);
        
        label10.setBounds(300,400,500,20);
        
        label11.setBounds(300,450,500,20);
        
        label12.setBounds(300,500,500,20);
        label13.setBounds(300,550,500,20);
        
        label14.setBounds(300,600,500,20);
               panel4.add(closebutton3);
               panel4.add(label7);
               panel4.add(coolbigstring);
               panel4.add(label8);
               panel4.add(label10);
               
               panel4.add(label11);
               
               panel4.add(label12);
               
               panel4.add(label13);
               
               panel4.add(label14);
               frame4.add(panel4, BorderLayout.CENTER);  
               frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame4.setTitle("Nile Dot Com - FINAL INVOICE");
               //frame4.pack();
               frame4.setVisible(true);
                frame4.setSize(1000,800);
                

                button.setEnabled(false);     
                button2.setEnabled(false);
                button4.setEnabled(false);
                text.setEnabled(false);
                text2.setEnabled(false);





        }
        
        else if (evt.getSource()==closebutton) {
            frame2.dispose();
        }
        else if (evt.getSource()==closebutton2) {
            frame3.dispose();
        }
        else if (evt.getSource()==closebutton3) {
            frame4.dispose();
        }
        else if (evt.getSource()==button6) {
            frame.dispose();
        }
        else if (evt.getSource()==button7) {
            cart.clear();
            cart2.clear();
            runningtotal=0;
            
           int items = cart.size();
            label3.setText("Details for Item #" + (items+1));

            label5.setText("Enter Item ID for Item #" + (items+1));
            
            label2.setText("Enter quntity for Item #"+(items+1));
            
            label6.setText(""+String.format("%.2f",runningtotal));
            
            label4.setText("Order Subtotal for "+(items)+ " item(s)");
            
            button.setText("Find Item #"+(items+1));
            
            button2.setText("Purchase item #"+(items+1));
            label.setText(" ");
            button.setEnabled(true);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            
            text.setEnabled(true);
            text2.setEnabled(true);

        }

}
}
