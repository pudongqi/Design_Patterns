package Observer_Pattern;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginValidatorB extends JFrame implements LoginEventListener {

	//具体观察者类
	//判断用户名和密码是否相同
	private JPanel p;
	private LoginBean lb;//定义具体目标
	private JLabel lbLogo;
	public LoginValidatorB() {
		super( "FaceBook" );
		p = new JPanel();
		this.getContentPane().add( p );
		lb = new LoginBean();
		lb.addLoginEventListener( this );//调用目标对象的注册方法

		Font f = new Font( "Times New Roman", Font.BOLD, 30 );
		lbLogo = new JLabel( "FaceBook" );
		lbLogo.setForeground( Color.red );

		p.setLayout( new GridLayout( 2,1 ) );
		p.add( lbLogo );
		p.add( lb );
		p.setBackground( new Color(163, 185, 255) );
		this.setSize( 600,200 );
		this.setVisible( true );
	}

	//实现在抽象观察者中声明的相应方法
	public void validateLogin( LoginEvent event ){
		String userName = event.getUserName();
		String passWord = event.getPassWord();

		if( userName.equals( passWord ) ){
			JOptionPane.showMessageDialog( this, new String(" UserName must be different from passWord! "), "alert", JOptionPane.ERROR_MESSAGE );
		}
		else{
			JOptionPane.showMessageDialog( this, new String(" Right Details! "),"alert",JOptionPane.INFORMATION_MESSAGE );
		}
	}

	public static void main( String args[] ){
		new LoginValidatorB().setVisible( true );
	}
}
