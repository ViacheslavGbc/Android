package ca.georgebrown.pawluk.lab4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class MyArrayAdapter extends ArrayAdapter<Student> {
    int layout;
    public MyArrayAdapter(@NonNull Context context,
                          int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout, null);
        }

        Student item = getItem(position);
        TextView t = convertView.findViewById(R.id.text1);
        t.setText(item.getId()+" "+item.getName());

        return convertView;
    }
}
