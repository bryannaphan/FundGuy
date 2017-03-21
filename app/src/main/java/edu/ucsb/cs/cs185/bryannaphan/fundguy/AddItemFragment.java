
package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static edu.ucsb.cs.cs185.bryannaphan.fundguy.R.id.add_picture;
import static edu.ucsb.cs.cs185.bryannaphan.fundguy.R.id.imageButton;
import static java.lang.Integer.parseInt;


public class AddItemFragment extends DialogFragment  {
    Boolean edit;
    Item item;
    private static int SELECT_PICTURE = 1;
    Bitmap bm;



    @Override
    public void onDismiss(DialogInterface dialog){
        super.onDismiss(dialog);
    }

    public void onEdit(Item item, Boolean edit){
        this.item = item;
        this.edit = edit;

    }
    public AddItemFragment() {
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
        final ImageButton imageButton = (ImageButton) in.findViewById(R.id.imageButton);                //get the image/bitmap here

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
                        description.getText().toString(), category.getSelectedItem().toString(), bm);
                ItemManager im = ItemManager.getInstance();
                im.add(newItem);
                AddItemFragment.this.dismiss();
            }
        });



       return in;
   }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //ImageView imageView;
        if (resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            try {
                bm = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
                ItemManager manager = ItemManager.getInstance();
                ImageView imageView = (ImageView) getView().findViewById(add_picture);
                imageView.setImageBitmap(bm);
            } catch (IOException e) {
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }
        }
    }


