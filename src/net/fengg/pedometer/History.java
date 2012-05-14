package net.fengg.pedometer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import net.fengg.pedometer.dbhelper.DatabaseHelper;
import net.fengg.pedometer.model.StepModel;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class History extends Activity {
	
	ListView mylist;
	HistoryAdapter adapter;
	List<StepModel> steps = new ArrayList<StepModel>();
	Button bt1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        
        mylist = (ListView) findViewById(R.id.mylist);
        
        
		try {
			Dao<StepModel, Integer> dao;
			dao = getHelper().getSimpleDataDao();
			
			steps = dao.queryForAll();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		adapter  = new HistoryAdapter(History.this, steps); 
		
        mylist.setAdapter(adapter);
        mylist.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub				
				try {	
					Log.i("", arg1.getId()+"");
					Dao<StepModel, Integer> dao;
					dao = getHelper().getSimpleDataDao();
					dao.deleteById(arg1.getId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				steps.remove(arg2);
				adapter.notifyDataSetChanged();
				Toast.makeText(History.this, getText(R.string.deleted), Toast.LENGTH_SHORT).show();
				return true;
			}
		});
        
   
        

        
    }
	
    private DatabaseHelper databaseHelper = null;
	private DatabaseHelper getHelper() {
		if (databaseHelper == null) {
			databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		}
		return databaseHelper;
	}
}