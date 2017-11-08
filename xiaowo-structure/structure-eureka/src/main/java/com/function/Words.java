package com.function;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gu.haiyan on 2017/11/8.
 */
public class Words {
    private Set<String> NON_WORDS = new HashSet<String>(){
        {
            add("the");
            add("and");
            add("of");
            add("to");
            add("a");
            add("i");
            add("it");
            add("in");
            add("or");
            add("is");
            add("d");
            add("s");
            add("as");
            add("so");
            add("but");
            add("be");
        }
    };

    public Map wordFreq(String words){
        TreeMap<String,Integer> wordMap = new TreeMap<String,Integer>();
        Matcher m = Pattern.compile("\\w+").matcher(words);
        while(m.find()){
            String word =m.group().toLowerCase();
            if(! NON_WORDS.contains(word)){
                if(wordMap.get(word) == null){
                    wordMap.put(word,1);
                }else {
                    wordMap.put(word,wordMap.get(word)+1);
                }
            }
        }
        return wordMap;
    }


    private List<String> regexToList(String words, String regex){
        List wordList = new ArrayList();
        Matcher m = Pattern.compile(regex).matcher(words);
        while(m.find())
        wordList.add(m.group());
        return wordList;
    }

    public Map wordFreq8(String words) {
        TreeMap<String,Integer> wordMap = new TreeMap<>();
        regexToList(words,"\\w+").stream()
                .map(w -> w.toLowerCase())
                .filter(w -> !NON_WORDS.contains(w))
                .forEach(w -> wordMap.put(w,wordMap.getOrDefault(w,0)+1));
        return wordMap;
    }
}
