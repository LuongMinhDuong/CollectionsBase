package advance.dev;

public class Circle extends Shape {
	protected double banKinh;
	
	
	public Circle(String name, double banKinh) {
		super(name);
		this.banKinh = banKinh;
	}

	@Override
	double chuVi() {
		// TODO Auto-generated method stub
		return Math.PI * banKinh * 2;
	}

	@Override
	double dienTich() {
		// TODO Auto-generated method stub
		return Math.PI * banKinh * banKinh;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Hinh tron co ban kinh la: %f", banKinh);
	}

}
