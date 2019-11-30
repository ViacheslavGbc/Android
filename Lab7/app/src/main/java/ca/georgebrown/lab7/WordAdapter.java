package ca.georgebrown.lab7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordAdapter
        extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    class WordViewHolder extends RecyclerView.ViewHolder{
        private final TextView wordTextView;

        private WordViewHolder(View layout){
            super(layout);
            wordTextView = layout.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<Word> mAllWords;

    WordAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    void setWords(List<Word> words){
        mAllWords = words;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                             int viewType) {
        View item = inflater.inflate(R.layout.item_layout, parent,
                false);
        return new WordViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if(mAllWords!=null){
            Word current = mAllWords.get(position);
            holder.wordTextView.setText(current.getWord());
        }else{
            holder.wordTextView.setText("---");
        }
    }

    @Override
    public int getItemCount() {
        return mAllWords!=null?mAllWords.size():0;
    }
}
