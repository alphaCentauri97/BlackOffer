package com.example.blackoffer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackoffer.databinding.PurposeItemBinding;

import java.util.List;
public class PurposeAdapter extends RecyclerView.Adapter<PurposeAdapter.ViewHolder> {

    Context context;
    List<String> purposeList;

    public PurposeAdapter(Context context, List<String> purposeList) {
        this.context = context;
        this.purposeList = purposeList;
    }

    @NonNull
    @Override
    public PurposeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.purpose_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvpurpose.setText(purposeList.get(position));

        holder.binding.tvpurpose.setOnClickListener(new View.OnClickListener() {
            boolean a = false;
            @Override
            public void onClick(View view) {
                if (!a) {
                    holder.binding.tvpurpose.setBackgroundResource(R.drawable.purpose_bg_green);
                    holder.binding.tvpurpose.setTextColor(context.getResources().getColor(R.color.white));
                    a = true;

                } else {
                    holder.binding.tvpurpose.setBackgroundResource(R.drawable.purpose_bg);
                    holder.binding.tvpurpose.setTextColor(context.getResources().getColor(R.color.black));
                    a = false;
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return purposeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        PurposeItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = PurposeItemBinding.bind(itemView);
        }
    }
}
