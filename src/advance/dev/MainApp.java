package advance.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MainApp {
	static List<Shape> readFromFile(String filename) throws IOException{
		List<Shape> listShapes = new ArrayList<Shape>();
		FileInputStream fs = new FileInputStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			if (strLine.indexOf("#rect") == 0) {
				String name = strLine.substring(1,strLine.length());
				double chieuDai = Double.parseDouble(br.readLine());
				double chieuRong = Double.parseDouble(br.readLine());
				Shape rect = new Rectangle(name, chieuDai, chieuRong);
				listShapes.add(rect);
			}
			if (strLine.indexOf("#tri") == 0) {
				String name = strLine.substring(1,strLine.length());
				double a = Double.parseDouble(br.readLine());
				double b = Double.parseDouble(br.readLine());
				double c = Double.parseDouble(br.readLine());
				Shape tri = new Triangle(name, a, b, c);
				listShapes.add(tri);
			}
			if (strLine.indexOf("#cir") == 0) {
				String name = strLine.substring(1,strLine.length());
				double banKinh = Double.parseDouble(br.readLine());
				Shape cir = new Circle(name, banKinh);
				listShapes.add(cir);
			}
		}
		return listShapes;
	}
	static void print(List<Shape> listshapes) {
		Iterator<Shape> it = listshapes.iterator();
		while (it.hasNext()) {
			Shape shape =  it.next();
			System.out.println(shape.toString());
		}
	}
	static void findMaxAll(List<Shape> listShapes) {
		Shape preMax = listShapes.get(0);
		Iterator<Shape> it = listShapes.iterator();
		while (it.hasNext()) {
			Shape shape = it.next();
			if (shape.dienTich() > preMax.dienTich()) preMax = shape; 
		}
	    System.out.println("\n----------------------------------------");
		System.out.printf("Dien tich lon nhat la hinh: %s, voi dien tich la: %f", preMax.name, preMax.dienTich());
	}
	static void findmax(List<Shape> listShapes) {
		Shape preC = listShapes.get(0);
		Shape preT = listShapes.get(0);
		Shape preR = listShapes.get(0);
	    Iterator<Shape> it = listShapes.iterator();
	    while (it.hasNext()) {
			Shape shape = it.next();
			if ((shape instanceof Circle) && (shape.dienTich() > preC.dienTich())) {
				preC = shape;
			}
			if ((shape instanceof Rectangle) && (shape.dienTich() > preR.dienTich())) {
				preR = shape;
			}
			if ((shape instanceof Triangle) && (shape.dienTich() > preT.dienTich())) {
				preT = shape;
			}
		}
	    String strC = String.format("Dien tich hinh tron lon nhat la: %f", preC.dienTich());
	    String strT = String.format("Dien tich hinh tam giac lon nhat la: %f ", preT.dienTich());
	    String strR = String.format("Dien tich hinh chu nhat lon nhat la: %f ", preR.dienTich());
	    
	    System.out.println("\n----------------------------------------");
	    System.out.println(strC);
	    System.out.println(strR);
	    System.out.println(strT);
	}
	public static void main(String[] args) {
		List<Shape> listShapes = new ArrayList<Shape>();
		try {
			listShapes = readFromFile("input.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(listShapes);
		findMaxAll(listShapes);
		findmax(listShapes);
	}
}
