
public class GrandSon implements Son {
	public static void main(String[] args) {
		GrandFather jimin = new GrandSon();  jimin.grandFather();
		//GrandFather는 본인의 메소드만 접근 가능
		Father chulsu = new GrandSon();   chulsu.grandFather();
		//Father는 본인 메소드와 GrandFather 메소드 접근 가능
		Mother younghee = new GrandSon();   younghee.mother();
		//Mother는 본인 메소드만 접근 가능
		Son youngsu = new GrandSon();    youngsu.son();
		//Son은 GrandFather, Father, Mother 그리고 본인 메소드 모두 접근 가능
		Son [] array = new Son[3];
		System.out.println(Father.NAME + ", " + Mother.NAME);
	}
	@Override
	public void father() { System.out.println("Called by father()");   }

	@Override
	public void grandFather() {   System.out.println("Called by grandFather()");  }

	@Override
	public void mother() {  System.out.println("Called by mother()"); }

	@Override
	public void son() {  System.out.println("Called by son()");  }

}
