
package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DecimalFormat;

import static java.lang.Integer.parseInt;


public class AddFragment extends DialogFragment {
    Boolean edit;
    PurchaseContent.Reminder reminder;


    @Override
    public void onDismiss(DialogInterface dialog){
        super.onDismiss(dialog);



    }

  public void onEdit(PurchaseContent.Reminder reminder, Boolean edit){
        this.reminder = reminder;
        this.edit = edit;

    }


    public AddFragment() {
        edit = false;
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View in = inflater.inflate(R.layout.add_fragment, container, false);
//        final TextView title = (TextView) in.findViewById(R.id.title);
//        final CheckBox mon = (CheckBox) in.findViewById(R.id.Monday);
//        final CheckBox tues = (CheckBox) in.findViewById(R.id.Tuesday);
//        final CheckBox wed = (CheckBox) in.findViewById(R.id.Wednesday);
//        final CheckBox thurs = (CheckBox) in.findViewById(R.id.Thursday);
//        final CheckBox fri = (CheckBox) in.findViewById(R.id.Friday);
//        final CheckBox sat = (CheckBox) in.findViewById(R.id.Saturday);
//        final CheckBox sun = (CheckBox) in.findViewById(R.id.Sunday);
//        final TimePicker time = (TimePicker) in.findViewById(R.id.timePicker);
//        final TextView description = (TextView) in.findViewById(R.id.description);
        if(edit) {
//            title.setText(reminder.title);
//            mon.setChecked(reminder.mon);
//            tues.setChecked(reminder.tues);
//            wed.setChecked(reminder.wed);
//            thurs.setChecked(reminder.thurs);
//            fri.setChecked(reminder.fri);
//            sat.setChecked(reminder.sat);
//            sun.setChecked(reminder.sun);
//            time.setHour(parseInt(reminder.time.split(":")[0]));
//            time.setMinute(parseInt(reminder.time.split(":")[1]));
//            description.setText(reminder.details);
//            Button button = (Button) in.findViewById(R.id.addnew);
//            button.setText("Edit");
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ReminderContent.editItem(reminder,
//                            title.getText().toString(),
//                            mon.isChecked(),
//                            tues.isChecked(),
//                            wed.isChecked(),
//                            thurs.isChecked(),
//                            fri.isChecked(),
//                            sat.isChecked(),
//                            sun.isChecked(),
//                            "" + (new DecimalFormat("00").format(time.getHour())) + ":" + (new DecimalFormat("00").format(time.getMinute())),
//                            description.getText().toString());
//                addFragment.this.dismiss();
//                }
//            });
        }
        else {
//            Button button = (Button) in.findViewById(R.id.addnew);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ReminderContent.Reminder newReminder = new ReminderContent.Reminder(
//                            title.getText().toString(),
//                            mon.isChecked(),
//                            tues.isChecked(),
//                            wed.isChecked(),
//                            thurs.isChecked(),
//                            fri.isChecked(),
//                            sat.isChecked(),
//                            sun.isChecked(),
//                            "" + (new DecimalFormat("00").format(time.getHour())) + ":" + (new DecimalFormat("00").format(time.getMinute())),
//                            description.getText().toString());
//                    ReminderContent.addItem(newReminder);
//                    addFragment.this.dismiss();
//                }});
        }
       return in;
//
   }


}