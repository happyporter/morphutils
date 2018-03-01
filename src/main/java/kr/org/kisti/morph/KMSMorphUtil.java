package kr.org.kisti.morph;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.lucene.analysis.kr.morph.AnalysisOutput;
import org.apache.lucene.analysis.kr.morph.CompoundEntry;
import org.apache.lucene.analysis.kr.morph.CompoundNounAnalyzer;
import org.apache.lucene.analysis.kr.morph.MorphAnalyzer;
import org.apache.lucene.analysis.kr.morph.MorphException;
import org.apache.lucene.analysis.kr.morph.WordSpaceAnalyzer;

/**
 *
 * @author hwang
 */
public class KMSMorphUtil {
    public static String morphAnalyze(String source) throws MorphException {
        StringBuilder result = new StringBuilder();
        MorphAnalyzer maAnal = new MorphAnalyzer();
        StringTokenizer stok = new StringTokenizer(source, " ");
        while(stok.hasMoreTokens()) {
            String token = stok.nextToken();
            List<AnalysisOutput> outList = maAnal.analyze(token);
            for(AnalysisOutput o: outList) {
                result.append(o).append(" ");
            }
        }
        return result.toString();
    }

    public static String wordSpaceAnalyze(String source, boolean force) throws MorphException {
        StringBuilder result = new StringBuilder();
        WordSpaceAnalyzer wsAnal = new WordSpaceAnalyzer();
        String s;
        if(force)
            s = source.replace(" ", "");
        else
            s = source;
        List<AnalysisOutput> outList = wsAnal.analyze(s);
        for(AnalysisOutput o: outList) {
            result.append(o.getSource()).append(" ");
        }

        return result.toString();
    }

    public static String wordSpaceAnalyze(String source) throws MorphException {
        return wordSpaceAnalyze(source, false);
    }

    public static String compoundNounAnalyze(String source) throws MorphException {
        StringBuilder result = new StringBuilder();
        CompoundNounAnalyzer cnAnal = new CompoundNounAnalyzer();
        List<CompoundEntry> outList = cnAnal.analyze(source);
        for(CompoundEntry o: outList) {
            result.append(o.getWord()).append(" ");
        }

        return result.toString();
    }

    public static List<String> guideWordList(String source) throws MorphException {
    	List<String> wordList = new ArrayList<String>();
        StringBuilder result = new StringBuilder();
        MorphAnalyzer maAnal = new MorphAnalyzer();
        StringTokenizer stok = new StringTokenizer(source, " ");
        while(stok.hasMoreTokens()) {
            String token = stok.nextToken();
            List<AnalysisOutput> outList = maAnal.analyze(token);
            for(AnalysisOutput o: outList) {
            	
            	wordList.add(o.getStem());
            	
//                result.append(o.getStem());
//                boolean first = true;
                for(CompoundEntry s : o.getCNounList()) {
//                    if(first) {
//                        result.append("(" + s.getWord());
//                        first = false;
//                    }
//                    else {
//                        result.append("+" + s.getWord());
//                    }
                	wordList.add(s.getWord());
                }
//                if(!first)
//                    result.append(")");
//                result.append(",");
            }
        }
//        String s = result.toString();
//        if(s.endsWith(","))
//            s = s.substring(0, s.length()-1);
//        return s;
        
        return wordList;
    }
}