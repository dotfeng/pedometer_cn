package net.fengg.pedometer;

import java.util.List;

import net.fengg.pedometer.model.StepModel;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HistoryAdapter extends BaseAdapter{
	private LayoutInflater mInflater;
	private List<StepModel> steps;
	
	public HistoryAdapter(Context context, List<StepModel> steps) {
		mInflater = LayoutInflater.from(context);
		this.steps = steps;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return steps.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return steps.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = mInflater.inflate(R.layout.history_item, null);
		TextView step = (TextView) convertView.findViewById(R.id.step);
		//TextView date = (TextView) convertView.findViewById(R.id.date);
		if(null != steps.get(position)) {
			step.setText(steps.get(position).toString());
		//	date.setText(steps.get(position).getDate());
			convertView.setId(steps.get(position).getId());
		}
		return convertView;
	}

}
