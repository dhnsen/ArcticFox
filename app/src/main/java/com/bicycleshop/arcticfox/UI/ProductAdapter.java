package com.bicycleshop.arcticfox.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bicycleshop.arcticfox.Entity.Product;
import com.bicycleshop.arcticfox.R;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    public ProductAdapter(Context context) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private final TextView productItemView;
        private ProductViewHolder(View itemView){
            super(itemView);
            productItemView = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Product current = mProducts.get(position);
                    Intent intent = new Intent(context, PartList.class);
                    intent.putExtra("id", current.getProductID());
                    intent.putExtra("name", current.getProductName());
                    intent.putExtra("price", current.getProductPrice());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Product> mProducts;
    private final Context context;
    private final LayoutInflater mInflater;
    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.activity_product_list_item, parent, false);
        return new ProductViewHolder((itemView));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        if (mProducts != null){
            Product current = mProducts.get(position);
            String name = current.getProductName();
            holder.productItemView.setText(name);
        }
        else{
            holder.productItemView.setText("No Product Name");
        }
    }

    @Override
    public int getItemCount() {
        if (mProducts != null) {
            return mProducts.size();
        }
        return 0;
    }

    public void setProducts(List<Product> products){
        mProducts = products;
        notifyDataSetChanged();
    }
}
