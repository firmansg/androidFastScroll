package firman.salatigadev.androidfastscroll.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
 
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;

import firman.salatigadev.androidfastscroll.R;

public class ListAdapter extends ArrayAdapter<String> implements SectionIndexer {
	
	HashMap<String, Integer> mapIndex;
    String[] sections;
    List<String> negara;
 
    public ListAdapter(Context context, List<String> listNegara) {
        super(context, R.layout.list_item, listNegara);
 
        this.negara = listNegara;
        mapIndex = new LinkedHashMap<String, Integer>();
 
        for (int x = 0; x < negara.size(); x++) {
            String ngr = negara.get(x);
            String ch = ngr.substring(0, 1);
            ch = ch.toUpperCase(Locale.US);
 
            // HashMap will prevent duplicates
            mapIndex.put(ch, x);
        }
 
        Set<String> sectionLetters = mapIndex.keySet();
 
        // create a list from the set to sort
        ArrayList<String> sectionList = new ArrayList<String>(sectionLetters);
 
        Log.d("sectionList", sectionList.toString());
        Collections.sort(sectionList);
 
        sections = new String[sectionList.size()];
 
        sectionList.toArray(sections);
    }
 
    public int getPositionForSection(int section) {
        Log.d("section", "" + section);
        return mapIndex.get(sections[section]);
    }
 
    public int getSectionForPosition(int position) {
        Log.d("position", "" + position);
        return 0;
    }
 
    public Object[] getSections() {
        return sections;
    }
}