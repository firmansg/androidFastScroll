package firman.salatigadev.androidfastscroll;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import firman.salatigadev.androidfastscroll.adapter.ListAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	ListView negaraView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		negaraView = (ListView) findViewById(android.R.id.list);
        
		negaraView.setFastScrollEnabled(true);
        String[] negara = getResources().getStringArray(R.array.daftar_negara);
 
        List<String> listNegara = Arrays.asList(negara);
        Collections.sort(listNegara);
        setListAdapter(new ListAdapter(this, listNegara));
        
        negaraView.setOnItemClickListener(new OnItemClickListener() {
 
            public void onItemClick(AdapterView<?> parent, View arg1,
                    int position, long arg3) {
                Toast.makeText(getApplicationContext(),
                        "" + parent.getItemAtPosition(position),
                        Toast.LENGTH_LONG).show();
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
