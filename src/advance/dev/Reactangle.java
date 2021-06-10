package advance.dev;

public class Reactangle extends Shape {
	protected double chieuDai,chieuRong;
	
	

	public Reactangle(String name, double chieuDai, double chieuRong) {
		super(name);
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	@Override
	double chuVi() {
		// TODO Auto-generated method stub
		return 2 * (chieuDai + chieuRong);
	}

	@Override
	double dienTich() {
		// TODO Auto-generated method stub
		return chieuDai * chieuRong;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Hinh chu nhat co chieu dai chieu rong la %f %f", chieuDai,chieuRong);
	}

}
