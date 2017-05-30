import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class main extends JFrame{
	JPanel panel;
	JFrame frame;
	public JTextField begin, end,count;
	public main(){
	    JPanel panel = new JPanel(new GridLayout(0,1));
		panel.setLayout(null);
		JButton hesapla = new JButton("Islem");
		hesapla.setBounds(100, 200, 100, 30);
		JLabel a = new JLabel ("Baslangic degeriniz giriniz:");
		a.setBounds(30, 20, 180, 20);
		JLabel b = new JLabel ("Bitis degeriniz giriniz:");
		b.setBounds(30, 50, 180, 20);
		JLabel c = new JLabel ("Uretilecek veri sayisini giriniz:");
		c.setBounds(30, 80, 180, 20);
		TextArea s = new TextArea();
		s.setEditable(false);
		s.setBounds(280, 20, 200, 200);
		begin=new JTextField();
		begin.setBounds(205, 20, 40,20);
		end=new JTextField();
		end.setBounds(205, 50, 40,20);
		count= new JTextField();
		count.setBounds(205, 80, 40, 20);
	       hesapla.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mousePressed(MouseEvent e) {
	                try {
		                int basla = Integer.parseInt(begin.getText());
		                int bitir = Integer.parseInt(end.getText());
		                int deger = Integer.parseInt(count.getText());
	                } catch (NumberFormatException e1) {
	                    s.setText("Lutfen Verileri Dogru ve \nEksiksiz Doldurun.");
	                    panel.add(s);
	                }
	                if(begin.getText().length() == 0||end.getText().length() == 0||count.getText().length() == 0) { 
	                	s.setText("Lutfen Verileri Dogru ve \nEksiksiz Doldurun.");
	                	panel.add(s);
	                }

	                else{
		                int basla = Integer.parseInt(begin.getText());
		                int bitir = Integer.parseInt(end.getText());
		                int deger = Integer.parseInt(count.getText());
		                if(bitir<basla){
		                	s.setText("Lutfen Verileri Dogru ve \nEksiksiz Doldurun.");
		                	panel.add(s);
		                }
		                else{
		                	int [] dizi = new int [deger];
		                	for (int i=0; i<deger; i++){
		                	dizi[i]=(basla+(int) (Math.random()*(bitir-basla)));
		                	}
		                	panel.add(s);
		                	s.setText("Uretilen sayilar\n");
		                	for (int j=0; j<dizi.length; j++){
		                	s.setText(s.getText()+dizi[j]+"\n");
		                	}
		                }	
	                }
	            }
	        });
		panel.add(a);
		panel.add(b);
		panel.add(begin);
		panel.add(end);
		panel.add(count);
		panel.add(c);
		panel.add(hesapla);
		setTitle("Rastgele Sayi Uretme");
		setBounds(100,100,550,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
 //O zamansa buraya bi yorum bırakarım değişiklik görmek için :)).
	}
	public static void main(String [] args){
		main m = new main();
	}
}
