package E����;

import java.util.HashMap;
import java.util.List;

/*
 * ���� DAO ��Ķ��� �ֱ������ save��get��update��list��delete ���������� User ����
ʹ�� Junit ��Ԫ��������в��ԡ�

 */
public class TestDAO {
   public static void main(String[] args) {
	   DAO<User> dao = new DAO<User>();
	   dao.map = new HashMap<String,User>();
	   
	   dao.save("1001",new User(1,32,"Kyle"));
	   dao.save("1002",new User(2,33,"Mar"));
	   dao.save("1002",new User(3,34,"Earth"));
	   
	   User u = dao.get("1001");
	   System.out.println(u);
	   
	   dao.update("1001", new User(4,45,"����"));
	   dao.delete("1003");
	   
	   List<User> list = dao.list();
	   System.out.println(list);
}
}
