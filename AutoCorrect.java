/* Authors: Tracy Nguyen, Are Oelsner
 * AutoCorrect File
 */
import java.util.*;
import java.io.File;
import java.util.HashMap;
import java.io.FileNotFoundException;

public class AutoCorrect{

    public static final int SHORTER_LEXICON_SIZE = 73;
    private static HashMap<Character, Integer[]> cMap;
    private static String[] m_dict = new String[SHORTER_LEXICON_SIZE]; ///< Variable that denotes the dictionary
    ////////////////////////////////////////////////////////////////////////////
    //* @brief: Constructor
    //* @param filename: name of file passed in
    public AutoCorrect(String filename){
        File file = new File(filename);

        try {
            Scanner sc = new Scanner(file);
            for(int i = 0; i < SHORTER_LEXICON_SIZE; i++){
                m_dict[i] = sc.next();
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        initializeCMap();
    }

    ////////////////////////////////////////////////////////////////////////////
    //* @brief: Initialize Character Map. Maps each character
    //* with its coordinates based on its keyboard position.
    public static void initializeCMap(){
        cMap.put('q', new Integer[]{0,2});
        cMap.put('w', new Integer[]{1,2});
        cMap.put('e', new Integer[]{2,2});
        cMap.put('r', new Integer[]{3,2});
        cMap.put('t', new Integer[]{4,2});
        cMap.put('y', new Integer[]{5,2});
        cMap.put('u', new Integer[]{6,2});
        cMap.put('i', new Integer[]{7,2});
        cMap.put('o', new Integer[]{8,2});
        cMap.put('p', new Integer[]{9,2});
        cMap.put('a', new Integer[]{1/3,1});
        cMap.put('s', new Integer[]{4/3,1});
        cMap.put('d', new Integer[]{7/3,1});
        cMap.put('f', new Integer[]{10/3,1});
        cMap.put('g', new Integer[]{13/3,1});
        cMap.put('h', new Integer[]{16/3,1});
        cMap.put('j', new Integer[]{19/3,1});
        cMap.put('k', new Integer[]{22/3,1});
        cMap.put('l', new Integer[]{25/3,1});
        cMap.put('z', new Integer[]{2/3,0});
        cMap.put('x', new Integer[]{5/3,0});
        cMap.put('c', new Integer[]{8/3,0});
        cMap.put('v', new Integer[]{11/3,0});
        cMap.put('b', new Integer[]{14/3,0});
        cMap.put('n', new Integer[]{17/3,0});
        cMap.put('m', new Integer[]{20/3,0});
    }

    ////////////////////////////////////////////////////////////////////////////
    //* @brief: Find Euclidean distance between two given characters
    //* @param key1: first given character
    //* @param key2: second given character
    //* @return a double representing distance between key1 and key2
    public static double computeDistance(char key1, char key2){
        double xSquared = (cMap.get(key1)[0] - cMap.get(key2)[0])*(cMap.get(key1)[0] - cMap.get(key2)[0]);
        double ySquared = (cMap.get(key1)[1] - cMap.get(key2)[1])*(cMap.get(key1)[1] - cMap.get(key2)[1]);
        return Math.sqrt(xSquared + ySquared);
    }

    ////////////////////////////////////////////////////////////////////////////
    //* @brief: Find closest word (with shortest edit distance)
    //* @param str: given word
    //* @return a string that is the closest word to the given word
    public static String findClosest(String str){
        return str;
    }
}
