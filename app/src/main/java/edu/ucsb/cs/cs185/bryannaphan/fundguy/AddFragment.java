
package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static edu.ucsb.cs.cs185.bryannaphan.fundguy.R.id.imageButton;
import static java.lang.Integer.parseInt;


public class AddFragment extends DialogFragment {
    Boolean edit;
    PurchaseContent.Reminder reminder;
    private static int SELECT_PICTURE = 1;

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

        ImageButton ib = (ImageButton) in.findViewById(imageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
//                intent.putExtra(MediaStore.EXTRA_OUTPUT,
//                        Uri.fromFile(photo));
//                Uri imageUri = Uri.fromFile(photo);
//                startActivityForResult(intent, TAKE_PICTURE);
                Intent pickIntent = new Intent();
                pickIntent.setType("image/*");
                pickIntent.setAction(Intent.ACTION_GET_CONTENT);

                Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                String pickTitle = "Select or take a new Picture"; // Or get from strings.xml
                Intent chooserIntent = Intent.createChooser(pickIntent, pickTitle);
                chooserIntent.putExtra
                        (
                                Intent.EXTRA_INITIAL_INTENTS,
                                new Intent[] { takePhotoIntent }
                        );

                startActivityForResult(chooserIntent, SELECT_PICTURE);
            }
        });

//        final TextView title = (TextView) in.findViewById(R.id.title);
//        final CheckBox mon = (CheckBox) in.findViewById(R.id.Monday);
//        final CheckBox tues = (CheckBox) in.findViewById(R.id.Tuesday);
//        final CheckBox wed = (CheckBox) in.findViewById(R.id.Wednesday);
//        final CheckBox thurs = (CheckBox) in.findViewById(R.id.Thursday);
//        final CheckBox fri = (CheckBox) in.findViewById(R.id.Friday);
//        final CheckBox sat = (CheckBox) in.findViewById(R.id.Saturday);
//        final CheckBox sun = (CheckBox) in.findViewById(R.id.Sunday);
//        final TimePicker time = (TimePicker) in.findViewById(R.id.timePicker);
//        final TextView description = (TextView) in.findViewById(R.id.description)
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

       return in;
//
   }


}