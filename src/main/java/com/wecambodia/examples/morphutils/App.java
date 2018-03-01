package com.wecambodia.examples.morphutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.lucene.analysis.kr.morph.MorphException;

import com.wcohen.ss.JaroWinkler;
import com.wcohen.ss.api.StringDistance;

import kr.org.kisti.morph.KMSMorphUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
//        System.out.println( "Hello World!" );
        
    	String subject = "올해 크리스마스에는 눈이 내리지 않고 비교적 포근할 전망이다.";

    	System.out.println("# 표제어");
    	System.out.println(subject + "\n\n");
        
    	System.out.println("# 표제어와의 유사어 추출 예제\n");
		
		List<String> keywordList = new ArrayList<String>();

		keywordList.add("올해 크리스마스에는");
		keywordList.add("올해 크리스마스에는 눈이 내리지 않고");
		keywordList.add("올해 크리스마스에는 눈이 내리지 않고 비교적 포근할 전망이다.");
		
		SortedMap<Double, String> sm = new TreeMap<>(Collections.reverseOrder());

		JaroWinkler jaro = new JaroWinkler();
		StringDistance distanceChecker = jaro.getDistance();
		
		int i = 1;

		for (String keyword : keywordList) {
			System.out.println("- 검색어 " + i + " : " + keyword);
			
			double similarity = distanceChecker.score(subject, keyword);
			sm.put(similarity, keyword);
			
			i++;
		}
		
		System.out.println("\n");
		
		int j = 1;

		for (Map.Entry<Double, String> entry : sm.entrySet()) {
			System.out.println("- 유사어 " + j + " : " + entry.getValue() + "(" + entry.getKey() + ")");
			j++;
		}
			
		
		System.out.println("\n\n");
		System.out.println("# 표제어에서 단어 추출 예제");
		
		try {
			List<String> wordList = KMSMorphUtil.guideWordList(subject);

			for (String word : wordList) {
				System.out.println(word);
			}
		} catch (MorphException e) {
			e.printStackTrace();
		}
    }
}
