package WordOccurences; 

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
	
	
	public class WordOccurences{

		public static Map<String,Integer> createWordMap () {
			String fileName = "C:\\Users\\Sern\\Documents\\School Work\\Undergrad\\Solo Projects\\Java\\WordDemo\\demo\\src\\main\\java\\WordOccurences\\text.txt";
			Map<String, Integer> wordMap = buildWordMap(fileName);
			List<Entry<String, Integer>> list = sortByValueInDecreasingOrder(wordMap);
			
			// Prints wordMap to console
			System.out.println("List of repeated words");
			for (Map.Entry<String, Integer> entry : list) {
			if (entry.getValue() > 1) 
				System.out.println(entry.getKey() + " -> " + entry.getValue());
			
			}

			return wordMap;
		}

		public static int numberWords (Map<String,Integer> wordMap, String word) {
			int count = 0;
			for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
				if (entry.getKey().equals(word)) {
					count = entry.getValue();
				}
			}
			return count;
		}

		public static Map<String, Integer> buildWordMap(String fileName) {
			Map<String, Integer> wordMap = new HashMap<>();
			try (FileInputStream fis = new FileInputStream(fileName);
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(dis))) {
				Pattern pattern = Pattern.compile("\\s+");
				String line = null;
				while ((line = br.readLine()) != null) {
					line = line.toLowerCase();
					String[] words = pattern.split(line);
					for (String word : words) {
						if (wordMap.containsKey(word)) {
						wordMap.put(word, (wordMap.get(word) + 1));
						} else {
						wordMap.put(word, 1);
						}
					}
				}
			} catch (IOException ioex) {
			ioex.printStackTrace();
			}
			return wordMap;
		}

		public static List<Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap) {
			Set<Entry<String, Integer>> entries = wordMap.entrySet();
			List<Entry<String, Integer>> list = new ArrayList<>(entries);
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
			return (o2.getValue()).compareTo(o1.getValue());
			}
			});
			return list;
			}
		}