package com.example.andprojdefault;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class LivreActivity extends Activity {

	private List<Livre> maBibliotheque = new ArrayList<Livre>();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_layout);
		setTheme(R.style.WidetBackground);
		
		
		ListView myListView = (ListView) findViewById(R.id.myListView);
		
		LivreAdapterBad adapter = new LivreAdapterBad(this, maBibliotheque);
		myListView.setAdapter(adapter);
		
	}
	
	public void remplirLaBibliotheque(){
		maBibliotheque.clear();
		maBibliotheque.add(new Livre("le livre", "le auteur"));
		maBibliotheque.add(new Livre("l'autre livre", "auteur"));
		maBibliotheque.add(new Livre("ce matin", "un lapin"));
	}
}
