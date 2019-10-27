package E泛型;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {
   private String OrderName;
   private Integer OrderId;
   private T t;
   List<T> list = new ArrayList<T>();
   public void add(){
	   list.add(t);//只能添加T类型声明的属性了
   }
   //声明泛型方法
   public <E> E getE(E e){
	   return e;
   }
   public void show(){
	   System.out.println(t);
   }
public String getOrderName() {
	return OrderName;
}
public void setOrderName(String orderName) {
	OrderName = orderName;
}
public Integer getOrderId() {
	return OrderId;
}
public void setOrderId(Integer orderId) {
	OrderId = orderId;
}
public T getT() {
	return t;
}
public void setT(T t) {
	this.t = t;
}

public Order() {
	super();
}
public Order(String orderName, Integer orderId, T t) {
	super();
	OrderName = orderName;
	OrderId = orderId;
	this.t = t;
}
@Override
public String toString() {
	return "Order [OrderName=" + OrderName + ", OrderId=" + OrderId + ", t=" + t + "]";
}
   
}
