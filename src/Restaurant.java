import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Restaurant extends JFrame{
    JLabel customer,name,contact,food,type,drink;
    JTextField tfNumber,tfName,tfContact;
    JButton reset,print,receipt;
    JComboBox cbFoods,cbDrinks;
    JRadioButton rbDiet,rbNormal;
    JTextArea area1;
    int fprice,dprice,total;

    public Restaurant(){

        setTitle("Restaurant and Coffee");
        setSize(800,700);
        setLayout(null);

        customer =new JLabel("Customer No: ");
        customer.setBounds(20, 50, 120, 30);
        getContentPane().add(customer);

        tfNumber=new JTextField();
        tfNumber.setBounds(150, 50, 200, 30);
        getContentPane().add(tfNumber);


        name =new JLabel("Name: ");
        name.setBounds(20, 100, 120, 30);
        getContentPane().add(name);
        tfName=new JTextField();
        tfName.setBounds(150, 100, 200, 30);
        getContentPane().add(tfName);


        contact =new JLabel("Contact: ");
        contact.setBounds(20, 150, 120, 30);
        getContentPane().add(contact);
        tfContact=new JTextField();
        tfContact.setBounds(150, 150, 200, 30);
        getContentPane().add(tfContact);

        food =new JLabel("Foods: ");
        food.setBounds(20, 200, 200, 30);
        drink =new JLabel("Drinks: ");
        drink.setBounds(20, 250, 200, 30);
        type =new JLabel("Type: ");
        type.setBounds(20, 300, 200, 30);
        getContentPane().add(food);
        getContentPane().add(drink);
        getContentPane().add(type);

        reset =new JButton("Reset");
        reset.setBounds(400,100,80,40);
        getContentPane().add(reset);

        print =new JButton("Print");
        print.setBounds(600,100,80,40);
        getContentPane().add(print);

        receipt =new JButton("Receipt");
        receipt.setBounds(500,100,80,40);
        getContentPane().add(receipt);


        String[] foods ={"Pizza","Burger","Pasta","Steak"};
        cbFoods= new JComboBox(foods);
        cbFoods.setBounds(150,200,200,30);
        getContentPane().add(cbFoods);


        String[] drinks ={"Cola","Fanta","Sprite","Icetea"};
        cbDrinks= new JComboBox(drinks);
        cbDrinks.setBounds(150,250,200,30);
        getContentPane().add(cbDrinks);

        rbDiet=new JRadioButton("Diet");
        rbDiet.setActionCommand("Diet");
        rbDiet.setBounds(150,300,100,30);
        getContentPane().add(rbDiet);

        rbNormal=new JRadioButton("Normal");
        rbNormal.setActionCommand("Normal");
        rbNormal.setBounds(250,300,100,30);
        getContentPane().add(rbNormal);

        ButtonGroup buttongroup1=new ButtonGroup();
        buttongroup1.add(rbDiet);
        buttongroup1.add(rbNormal);


        area1=new JTextArea();
        area1.setBounds(400,140,280,200);
        getContentPane().add(area1);

        //reset button for reset button
        reset.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tfNumber.setText("");
                tfContact.setText("");
                tfName.setText("");
                area1.setText("");
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });


        //print method for print button
        print.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    area1.print();
                    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } catch (PrinterException ex) {
                    System.out.print(ex.getMessage());
                    //Logger.getLogger(MyResturant.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //receipt method for receipt button
        receipt.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                area1.setText("Wellcome to our Restaurant\n");
                area1.setText(area1.getText()+
                        "Customer Number: " + tfNumber.getText()+
                        " \nCustomer Name: " + tfName.getText()+
                        " \nContact Name: " + tfContact.getText());
                area1.setText(area1.getText()+
                        "\nFood: " + cbFoods.getSelectedItem()+
                        "\nDrink: " + cbDrinks.getSelectedItem()+
                        "\nType: " + buttongroup1.getSelection().getActionCommand());

                if(cbFoods.getSelectedIndex()==0){
                    fprice=20;
                }

                if(cbFoods.getSelectedIndex()==1){
                    fprice=30;
                }

                if(cbFoods.getSelectedIndex()==2){
                    fprice=25;
                }

                if(cbFoods.getSelectedIndex()==3){
                    fprice=40;
                }

                if(cbDrinks.getSelectedIndex()== 0 || cbDrinks.getSelectedIndex()== 1  ){
                    dprice=3;
                    total=fprice+dprice;
                    area1.setText(area1.getText() + "\n Total: "+total );
                }

                if(cbDrinks.getSelectedIndex()== 2 || cbDrinks.getSelectedIndex()== 3  ){
                    total=fprice+dprice;
                    dprice=2;
                    total=fprice+dprice;
                    area1.setText(area1.getText() + "\n Total: " + total );
                }

                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
        );

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
