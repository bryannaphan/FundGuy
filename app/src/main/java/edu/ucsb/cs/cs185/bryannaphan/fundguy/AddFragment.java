
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static edu.ucsb.cs.cs185.bryannaphan.fundguy.R.id.imageButton;
import static java.lang.Integer.parseInt;


public class AddFragment extends DialogFragment  {
    Boolean edit;
    Item item;
    private static int SELECT_PICTURE = 1;



    @Override
    public void onDismiss(DialogInterface dialog){
        super.onDismiss(dialog);
    }

  public void onEdit(Item item, Boolean edit){
        this.item = item;
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

        final EditText title = (EditText) in.findViewById(R.id.purchase_title);
        final EditText amount = (EditText) in.findViewById(R.id.amount);
        final EditText  description = (EditText) in.findViewById(R.id.description);
        final Spinner category = (Spinner) in.findViewById(R.id.spinner);

        List<String> categories = new ArrayList<String>();
        categories.add("Bills");
        categories.add("Food");
        categories.add("Treat Yo Self");
        categories.add("Other");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(dataAdapter);


        Button save = (Button) in.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ONLY CREATE NOW, ADD EDIT FUNCTIONALITY LATER
                // ALSO NEED TO ADD THE BITMAP STUFF
                Item newItem = new Item(title.getText().toString(), Float.parseFloat(amount.getText().toString()),
                        description.getText().toString(), category.getSelectedItem().toString());
                ItemManager im = ItemManager.getInstance();
                im.add(newItem);
                AddFragment.this.dismiss();
            }
        });



       return in;

   }


}