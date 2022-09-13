package ProjectNew;

public abstract class Goods {
	private double priceUe;
	private static double exchangeRate = 43;// курс валют -прибрати або статична змінна
	private String title;// фірма
	private String color;
	private String series;// назва серії моделей
	private int article;
	private int quantity;// кількість товару
	private String type;// змішувач раковина ванна
	private int size;
	
	public Goods(String title, String series, int article,
			String type, String color, double priceUe, int quantity, int size) {
	                 
	//public Goods(double priceUe, String title, String color, String series, int article, int quantity, String type,
			//int size) {
		super();
		this.priceUe = priceUe;
		this.title = title;
		this.color = color;
		this.series = series;
		this.article = article;
		this.quantity = quantity;
		this.type = type;
		this.size = size;
	}

	public double getPriceUe() {
		return priceUe;
	}
	
	public void setPriceUe(double priceUe) {
		this.priceUe = priceUe;
	}
	
	public static double getExchangeRate() {
		return exchangeRate;
	}
	
	public static void setExchangeRate(double exchangeRate) {
		Goods.exchangeRate = exchangeRate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getSeries() {
		return series;
	}
	
	public void setSeries(String series) {
		this.series = series;
	}
	
	public int getArticle() {
		return article;
	}
	
	public void setArticle(int article) {
		this.article = article;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return getTitle() + " "+ getSeries() + " "+ getArticle() + " "+ getType() + " "+ getColor() + " "
				+ getPriceUe() + " "+ getQuantity() + " "+ getSize() + " ";
	}
	
	
}
