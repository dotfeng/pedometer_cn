package net.fengg.pedometer.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;


public class StepModel { 
@DatabaseField(generatedId = true) 
int id; 
@DatabaseField 
String mStepValue;
@DatabaseField 
String mStepUnits;
@DatabaseField 
String mDistanceValue;
@DatabaseField 
String mDistanceUnits;
@DatabaseField
String mPaceValue;
@DatabaseField
String mPaceUnits;
@DatabaseField 
String mSpeedValue;
@DatabaseField 
String mSpeedUnits;
@DatabaseField 
String mCaloriesValue;
@DatabaseField 
String mCaloriesUnits;
@DatabaseField
String date;

public StepModel() { 
} 
public StepModel(
		String mStepValue,
		String mStepUnits,
		String mDistanceValue, 
		String mDistanceUnits, 
		String mPaceValue,
		String mPaceUnits,
		String mSpeedValue,
		String mSpeedUnits,
		String mCaloriesValue,
		String mCaloriesUnits) {
	this.mStepValue = mStepValue;
	this.mStepUnits = mStepUnits;
	this.mDistanceValue = mDistanceValue;
	this.mDistanceUnits = mDistanceUnits;
	this.mPaceValue = mPaceValue;
	this.mPaceUnits = mPaceUnits;
	this.mSpeedValue = mSpeedValue;
	this.mSpeedUnits = mSpeedUnits;
	this.mCaloriesValue = mCaloriesValue;
	this.mCaloriesUnits = mCaloriesUnits;
	this.date =  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());	
} 

public String getDate() {
	return date;
}
public int getId() {
	return id;
}

@Override 
public String toString() { 
  StringBuilder sb = new StringBuilder(); 
  sb.append(mDistanceValue + " " + mDistanceUnits + ", ");
  sb.append(mCaloriesValue + " " + mCaloriesUnits + ", ");
  sb.append(date);
  return sb.toString(); 
} 

}