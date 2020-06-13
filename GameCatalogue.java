import java.io.*;
import java.util.*;

public class GameCatalogue {
	private final int numvideogames = 25;
	//private String userName;
	Hash<VideoGames> hash = new Hash<>(numvideogames * 2);
	BST<VideoGames> bst = new BST<>();

	public static void main(String[] args) throws IOException{
		GameCatalogue gameCatalogue = new GameCatalogue();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to your video game library!");
		
		//try catch block for valid file from user
		boolean isTrue = true;
		String fileName;
		while(isTrue) {
			try {
				System.out.println("Enter text file name");
				fileName = input.nextLine();
				gameCatalogue.readFile(fileName);
				isTrue = false;
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
		input.close();
		
		//place holder file output
				File outFile = new File("out.txt");
				PrintWriter output = null;
				try {
					output = new PrintWriter(outFile);
				} catch(FileNotFoundException e) {
					System.out.println("File doesn't exist");
				}
				//System.out.println(gameCatalogue.hash);
				output.print(gameCatalogue.hash.toString());
				output.close();
		gameCatalogue.hash.toString();

	}
	/**
	 * reads file content 
	 * @precondition fileName exists
	 * @throws IOException if file does not exist
	 */
	public void readFile(String fileName) throws IOException{
		File inFile = new File(fileName);
		
		if(!inFile.exists()) {
			throw new IOException("readFile cannot find the file");
		}
		Scanner in = new Scanner(inFile);
		
		while(in.hasNext()) {
			String serialNum = in.nextLine();
			String title = in.nextLine();
			String publisher = in.nextLine();
			int year = in.nextInt();
			in.nextLine();
			String rating = in.nextLine();
			
			if(in.hasNextLine()) {
				in.nextLine();
			}
			
			System.out.println("serialNum: " + serialNum);
			System.out.println("title: " + title);
			System.out.println("publisher: " + publisher);
			System.out.println("year: " + year);
			System.out.println("rating: " + rating);
			
			VideoGames v = new VideoGames(serialNum, title, year, publisher, rating);
			hash.insert(v);
			bst.insert(v);
		}
		in.close();
	}
	
	/**
	 * outputs the hash contents onto file by calling on hash.printOut
	 */
	public void writeFile() throws IOException{
		File outFile = new File("out.txt");
		PrintWriter output = new PrintWriter(outFile);
		hash.printOut(output);
	}
	
	}

