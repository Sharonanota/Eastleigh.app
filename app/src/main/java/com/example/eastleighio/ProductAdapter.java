package com.example.eastleighio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.viewHolder> {
    ProductData[] productData;
    Context context;

    public ProductAdapter (ProductData[] productData, MainActivity activity ) {
        this.productData = productData;
        this.context = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.products_item_list,parent,false);
        viewHolder viewHolder = new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final ProductData productDataList = productData[position];




        holder.textViewName.setText(ProductData.getProductName());
        holder.textViewData.setText(productDataList.getProductName());
        holder.textViewData.setText(productDataList.getProductData());
        holder.ProductImage.setImageResource(productDataList.getProductImage());

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(context,ProductData.getProductName(), Toast.LENGTH_SHORT).show();
             }
         });
    }
    @Override
    public int getItemCount() {
        return productData.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView ProductImage;
        TextView textViewName;
        TextView textViewData;

        public viewHolder (@NonNull View itemView) {
            super(itemView);
            ProductImage=itemView.findViewById(R.id.imageview);
            textViewName =  itemView.findViewById(R.id.textyy);
            textViewData = itemView.findViewById(R.id.body);
        }
    }
}
