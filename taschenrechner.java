import java.awt.;
import javax.swing.;
import java.awt.event.*; // importiert das grafische Fenster
public class taschenrechner extends JFrame implements ActionListener {

private JTextField txtvar1 = new JTextField();
private JTextField txtvar2 = new JTextField();
private JTextField txtErg = new JTextField();

private JLabel lblVar1 = new JLabel("Variable 1");  // mit LABEL kann Text in Objekte eingefügt werden
private JLabel lblVar2 = new JLabel("Variable 2");
private JLabel lblErg = new JLabel("Ergebnis");  

private JButton btplus = new JButton("+");
private JButton btminus = new JButton("-");
private JButton btmal = new JButton("*");
private JButton btgeteilt = new JButton("/");
private JButton btexpo = new JButton("^");
private JButton btpro = new JButton("Restwert");
private JButton btDel = new JButton("Löschen");


public taschenrechner() // mit PUBLIC werden die Rückgabewerte ausserhalb des Objekts sichtbar
{
    Container cp = getContentPane();
    cp.setLayout(null);

    lblVar1.setBounds(120,10,60,20);
    txtvar1.setBounds(190,10,120,20);
    lblVar2.setBounds(120,40,190,20);
    txtvar2.setBounds(190,40,120,20);
    lblErg.setBounds(120,70,190,20);
    txtErg.setBounds(190,70,120,20);
    txtErg.setEditable(false);

    btplus.setBounds(120,120,50,20);
    btminus.setBounds(170,120,50,20);
    btmal.setBounds(220,120,50,20);
    btgeteilt.setBounds(270,120,50,20);
    btexpo.setBounds(320,120,50,20);
    btpro.setBounds(370,120,50,20);
    btDel.setBounds(120,150,100,20);


    cp.add(lblVar1);  // CP steht für Control Panel und steuert automatisch die Darstellung der Werte in der Grafik
    cp.add(lblVar2);
    cp.add(txtvar2);
    cp.add(txtvar1);
    cp.add(txtErg);
    cp.add(lblErg);
    cp.add(btplus);
    cp.add(btminus);
    cp.add(btmal);
    cp.add(btgeteilt);
    cp.add(btexpo);
    cp.add(btpro);
    cp.add(btDel);   

    setTitle("Taschenrechner");
    setSize(660,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // <-- Fenster ist sichtbar, läuft NICHT im Hintergrund

    btplus.addActionListener(this);  // Action Listener bestätigt eine Schaltfläche
    btminus.addActionListener(this);
    btmal.addActionListener(this);
    btgeteilt.addActionListener(this);
    btexpo.addActionListener(this);
    btpro.addActionListener(this);
    btDel.addActionListener(this); 
}


public void actionPerformed(ActionEvent event) // mit VOID können versch. und mehrere Klassen zugleich auf das Geschehen zugreifen
{
    double var1,var2;
    Object obj = event.getSource();

    if (obj == btplus) {
        var1 = Double.parseDouble(txtvar1.getText()); // mit Hilfe von DOUBLE können Kommazahlen dargestellt werden
        var2 = Double.parseDouble(txtvar2.getText());

        var1 = var1+var2;
        txtErg.setText(""+var1);

    } // Ende Addieren

    if (obj == btminus) {
        var1 = Double.parseDouble(txtvar1.getText());
        var2 = Double.parseDouble(txtvar2.getText());

        var1 = var1-var2;
        txtErg.setText(""+var1);

    } // Ende Subtrahieren

    if (obj == btmal) {
        var1 = Double.parseDouble(txtvar1.getText());
        var2 = Double.parseDouble(txtvar2.getText());

        var1 = var1*var2;
        txtErg.setText(""+var1);

    } // Ende Multiplizieren

    if (obj == btgeteilt) {
        var1 = Double.parseDouble(txtvar1.getText());
        var2 = Double.parseDouble(txtvar2.getText());

        var1 = var1/var2;
        txtErg.setText(""+var1);

    } // Ende Dividieren

     if (obj == btexpo) {
        var1 = Double.parseDouble(txtvar1.getText());
        var2 = Double.parseDouble(txtvar2.getText());

        var1 = Math.pow(var1, var2); // manche mathematische Operatoren müssen mit MATH erzeugt werden
        txtErg.setText(""+var1);

    } // Ende Potenzieren

      if (obj == btpro) {
        var1 = Double.parseDouble(txtvar1.getText());
        var2 = Double.parseDouble(txtvar2.getText());

        var1 = var1%var2;
        txtErg.setText(""+var1);

    } // Ende Restwert


    if (obj==btDel) {
        txtvar1.setText("");
        txtvar2.setText("");
        txtErg.setText("");

    } // ENDE Löschen
   }


public static void main (String[] args){
    taschenrechner taschenrechner = new taschenrechner();
}
}
