package test;

import java.util.ArrayList;
import java.util.List;

class FileItem {
	private String string;
	private String name;

	public FileItem() {

	}

	public FileItem(String string, String name) {
		super();
		this.string = string;
		this.name = name;
	}

	@Override
	public String toString() {
		return "FileItem [string=" + string + ", name=" + name + "]";
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class FileTest {

	public static List<FileItem> parse() {
		List<FileItem> fList = new ArrayList<FileItem>();
		FileItem fi = new FileItem("tmName", "신과함께");
		fList.add(fi);

		fi = new FileItem("tcPrice", "20000");
		fList.add(fi);
		fi = new FileItem("tcDesc", "원작 웹툰");
		fList.add(fi);

		return fList;
	}

	public static void main(String[] args) {
		List<FileItem> fList = parse();
		for (FileItem fi : fList) {
			if (fi.getName().equals("tmName")) {

				System.out.println(fi.getString());

			}
		}

	}
}
