package bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import model.UserList;
//检测登入人数
public class UserTest implements HttpSessionBindingListener {
	private String name;
	private UserList ul = UserList.getInstance();

	public UserTest() {
	}

	public UserTest(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		ul.addUser(name);
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		ul.removeUser(name);
	}
}