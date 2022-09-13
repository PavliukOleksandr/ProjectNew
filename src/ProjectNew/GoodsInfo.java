package ProjectNew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GoodsInfo {
	static ArrayList<Plumbing> list = new ArrayList<>();
	private static String path = ".\\src\\ProjectNew";
	private static String fileName = "Goods.txt";
	private static String fileName2 = "Goods2.txt";
	private static String line = null;
	private static String ask;
	
	public static void allInfo() {
		try (FileReader reader = new FileReader(path + File.separator + fileName)) {
			BufferedReader bufferedReader = new BufferedReader(reader);

			while ((line = bufferedReader.readLine()) != null) {
				String[] res = line.split("\\s+");       
				list.add(new Plumbing(res[0], res[1], Integer.parseInt(res[2]), res[3],
						res[4], Double.parseDouble(res[5]), Integer.parseInt(res[6]), Integer.parseInt(res[7])));
			}
		} catch (Exception e) {
			System.out.println("Catch 2");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static void chageGoodsAmmount(int article, int ch) {
		try (FileReader reader = new FileReader(path + File.separator + fileName);
				FileWriter writer =  new FileWriter(path + File.separator + fileName)) {
			BufferedReader bufferedReader = new BufferedReader(reader);

			while ((line = bufferedReader.readLine()) != null) {
				String[] res = line.split("\\s+");       
				list.add(new Plumbing(res[0], res[1], Integer.parseInt(res[2]), res[3],
						res[4], Double.parseDouble(res[5]), Integer.parseInt(res[6]), Integer.parseInt(res[7])));
			} 
			for (Plumbing plumbing : list) {	
				if (plumbing.getArticle() == article) {
					plumbing.setQuantity(ch);
					System.out.println(plumbing);
					break;
				}
			}
			for(Plumbing plumbing: list) {
				writer.write(plumbing.toString() + "\n");
			}
		} catch (Exception e) {
			System.out.println("Catch 2");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	/*
	 * пошук по артикулу
	 */
	public static Plumbing plumbing(int article) {
		Plumbing current = null;
		for (Plumbing plumbing : list) {
			if (plumbing.getArticle() == article) {
				current = plumbing;
				break;
			}
		}
		return current;
	}
	/*
	 * пошук по серії
	 */
	public static void plumbing1(String series) {
		for (Plumbing plumbing1 : list) {
			if (plumbing1.getSeries().startsWith(series)) {
				System.out.println(plumbing1);
			}
		}
	}
	/*
	 * вивелення всії данних на екран
	 */
	public static void reading() {
		try (FileReader reader = new FileReader(path + File.separator + fileName)) {
			int c;
			while ((c = reader.read()) != -1) {
				List<Character> qwerty = new ArrayList<Character>();
				qwerty.add((char) c);
				System.out.print((char) c);
			}
			System.out.println(" ");
			System.out.println(" ");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/*
	 * прайс для всього товару
	 */	
	public static void exchangeAll(double d) {
		System.out.println("Exchange rate - " + d);
		for (Plumbing plumbing : list) {
			System.out.println(plumbing.getTitle() + " " + plumbing.getSize() + " " + plumbing.getPriceUe() * d);
		}
	}
	/*
	 *    прайс по імені
	*/
	public static void exchangeSeries(double d, String name) {
		System.out.println("Exchange rate - " + d);
		for (Plumbing plumbing : list) {
			if(plumbing.getSeries().startsWith(name)) {		
			System.out.println(plumbing.getSeries() + " " + plumbing.getType() + " " + plumbing.getSize() + " " + 
					plumbing.getPriceUe() * d);
			}
		}
	}
	
	public static void sortingUp(String series) {
		System.out.println("Сортування по ціні з меншої до більшої");
		Collections.sort(list, new PriceComparator2());
		for(Plumbing plumbing: list) {
			if (plumbing.getSeries().startsWith(series)) {
				System.out.println(plumbing);
			}	
		}	
			
	}
	
	public static void sortingDown(String series) {
		System.out.println("Сортування по ціні з меншої до більшої");
		Collections.sort(list, new PriceComparator1());
		for(Plumbing plumbing: list) {
			if (plumbing.getSeries().startsWith(series)) {
				System.out.println(plumbing);
			}	
		}		
	}
	public static void main(String[] args) {
		Scanner sk = new Scanner(System.in);
		allInfo();
		
		System.out.println("Вибрати дію");
		System.out.println("1 - знайти товар по коду");
		System.out.println("2 - знайти товар по назві");
		System.out.println("3 - вивести інформацію про всі товари");
		System.out.println("4 - змінити кількість товару");
		System.out.println("5 - вивести назву усіх товарів і ціну з урахуванням курсу в гривнях");
		System.out.println("6 - вивести назву товару і ціну з урахуванням курсу в гривнях");
		System.out.println("7 - сортування по ціни з меншої до більшої");
		System.out.println("8 - сортування по ціні з більшої до меншої");
		
		do {
		switch(sk.nextInt()) {
		case 1: 
			System.out.println("Введіть артикул товару");
			int i = sk.nextInt();
			System.out.println(plumbing(i));
			break;
		case 2:
			System.out.println("Введіть назву товару");
			String s = sk.next().toLowerCase();
			plumbing1(s);
			break;
		case 3:
			reading();
			break;
		case 4:
			System.out.println("Введіть артикул товару");
			int q = sk.nextInt();
			System.out.println("Веедіть кількість товару");
			int il = sk.nextInt();
			chageGoodsAmmount(q, il);
			break;
		case 5:
			System.out.println("Введіть курс валют, щоб отримати перерахунок у гривнях для всіх товарів");
			double d = Double.parseDouble(sk.next()) ;
			exchangeAll(d);
			break;
		case 6:
			System.out.println("Введіть курс валют та назву серії, "
					+ "щоб отримати перерахунок у гривнях");
			double db = Double.parseDouble(sk.next());
			String name = sk.next().toLowerCase();
			exchangeSeries(db, name);
			break;
		case 7:
			System.out.println("Введіть назву товару");
			String sor1 = sk.next().toLowerCase();
			sortingUp(sor1);
			break;
		case 8:
			System.out.println("Введіть назву товару");
			String sor2 = sk.next().toLowerCase();
			sortingDown(sor2);
			break;
		}
		System.out.println("Type to continue: Y or YES \nAny another to stop");
		ask = sk.next().toUpperCase();
		}while(ask.equals("YES") || ask.equals("Y") );
		sk.close();
	}
}
