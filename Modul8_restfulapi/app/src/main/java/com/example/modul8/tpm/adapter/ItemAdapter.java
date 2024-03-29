package com.example.modul8.tpm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.modul8.R;
import com.example.modul8.tpm.model.getbyid.DataItem;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {
    private Context context;
    private List<DataItem> item;
    private OnAdapterClickListener listener;

    public ItemAdapter(Context context, List<DataItem> item, OnAdapterClickListener listener) {
        this.context = context;
        this.item = item;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_items, viewGroup, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.Holder holder, int i) {
        holder.bind(i, listener);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public interface OnAdapterClickListener {
        void onClicked(String id, String name, String description, String key);
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tvName, tvDescription, tvId;
        private Button btnEdit, btnDelete;

        public Holder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            btnEdit = itemView.findViewById(R.id.btn_edit);
        }

        public void bind(final int position, final OnAdapterClickListener listener) {
            tvId.setText(String.valueOf(item.get(position).getId()));
            tvName.setText(String.valueOf(item.get(position).getName()));
            tvDescription.setText(String.valueOf(item.get(position).getDescription()));

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClicked(String.valueOf(item.get(position).getId()), item.get(position).getName(), item.get(position).getDescription(), "edit");
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClicked(String.valueOf(item.get(position).getId()), item.get(position).getName(), item.get(position).getDescription(), "delete");
                }
            });
        }
    }

}
