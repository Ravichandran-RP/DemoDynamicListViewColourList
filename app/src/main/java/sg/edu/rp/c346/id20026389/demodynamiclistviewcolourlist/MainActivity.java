package sg.edu.rp.c346.id20026389.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaClour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement=findViewById(R.id.editTextColour);
        btnAdd=findViewById(R.id.buttonAddItem);
        btnRemove=findViewById(R.id.buttonRemoveItem);
        btnUpdate=findViewById(R.id.buttonUpdateItem);
        etIndexElement=findViewById(R.id.editTextIndex);
        lvColour=findViewById(R.id.listViewColour);
        alColours=new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");
        aaClour=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaClour);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etElement.getText().toString().length()>0 && etIndexElement.getText().toString().length()>0){
                    int pos=Integer.parseInt(etIndexElement.getText().toString());
                    alColours.add(pos,etElement.getText().toString());
                    aaClour.notifyDataSetChanged();
                    etElement.setText(null);
                    etIndexElement.setText(null);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please enter all the values", Toast.LENGTH_SHORT).show();
                }
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour=alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alColours.size()>0){
                    if(etIndexElement.getText().toString().length()>0){
                        if(Integer.parseInt(etIndexElement.getText().toString())<alColours.size()){
                            alColours.remove(Integer.parseInt(etIndexElement.getText().toString()));
                            aaClour.notifyDataSetChanged();
                            etElement.setText(null);
                            etIndexElement.setText(null);
                            Toast.makeText(MainActivity.this, "Successfully removed clour in index "+etIndexElement.getText().toString(),
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Index chosen is invalid", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Please provide index of colour", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "There is no colour to remove", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}