/* Assignment 10 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (50 marks in total)
    Use the Q1_TreeMapByBST to implement a WordCounter to count words in documents.
    You cannot use JCF provided map.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Q2_WordCounter {
    // use the m_treemap as the data structure for word counting
    Q1_TreeMapByBST m_treemap = new Q1_TreeMapByBST();

    // Question 2.1 (15 marks) implement buildTreeMap() to build a treemap that stores
    // the words and word frequencies of a document into m_treemap.
    // "filename" is the path to the file. Please use the "JingleBell.txt" under folder "data".
    // You can ONLY modify the body of this method including the return statement.
    public void buildTreeMap(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        ArrayList<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            String word  = scanner.next();
            word = word.toLowerCase();
            if (word.contains("-")) {
                words.add(word.split("-")[0]);
                words.add(word.split("-")[1]);
                continue;
            } else if (!word.matches("[a-zA-Z']+")) {
                String letters_only = "";
                for (char c : word.toCharArray()) {
                    if (Character.isLetter(c)) letters_only += c;
                }
                if (!letters_only.isEmpty()) words.add(letters_only);
                continue;
            }
            words.add(word);
        }
        for (String word : words) {
            int freq = (m_treemap.get(word) == -1) ? 1 : m_treemap.get(word)+1;
            m_treemap.put(word, freq);
        }
    }

    // Question 2.2 (15 marks) print all the counted words in the document in alphabetical order.
    // You can ONLY modify the body of this method including the return statement.
    public void printWordsAlphabetical(){
        for (String key : m_treemap.getKeysInAlphabeticalOrder()) System.out.println(key);
    }

    // Question 2.3 (15 marks) write an output file named "Output.txt" under folder "data"
    // The output of will consist of two lists.
    // Each list contains all the words from the file, along with the number of times
    // that the word occurred.
    // One list is sorted alphabetically.
    // The other list is sorted according to the number of occurrences, with the most
    // common words (i.e., a word with a larger frequency or count is said to be more common)
    // at the top and the least common at the bottom.
    // IMPORTANT: the output format is given in the file "Output_Example.txt" under folder "data".
    // Input parameter "filename" is the path to the output file.
    public void outputResult(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            ArrayList<String> words = m_treemap.getKeysInAlphabeticalOrder();

            writer.write(words.size() + " words found in file:\n\n");
            writer.write("List of words in alphabetical order (with counts in parentheses):\n\n");
            for (String word : words) {
                writer.write("\t"+word+" "+"("+m_treemap.get(word)+")\n");
            }

            writer.write("\n\nList of words by frequency of occurence:\n\n");
            int max = -1;
            for (String word : words) {
                if (max < m_treemap.get(word)) max = m_treemap.get(word);
            }

            while (max != 0) {
                for (String word : words) {
                    if (max == m_treemap.get(word)) writer.write("\t"+word+" "+"("+max+")\n");
                }
                max -= 1;
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Question 2.4 (5 marks) call each of the above methods in the main() method to
    // successfully count the words and produce expected outputs.
    public static void main(String[] args){
        Q2_WordCounter word_counter = new Q2_WordCounter();
        try {
            word_counter.buildTreeMap("./src/data/JingleBell.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        word_counter.printWordsAlphabetical();
        word_counter.outputResult("./src/data/Output.txt");
    }

}
