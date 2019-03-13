package ekrmadonate;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.awad.ekrma.ekrmadonate.R;

import java.util.List;

import ekrmadonate.taskfragments.MyTasksFragment;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link MyTasksFragment.OnListFragmentInteractionListener}
 * interface.
 */
class  ExampleAdapter extends BaseAdapter {
    List<Product> products;
    private Activity context;

    @Override
    public int getCount() {
        return products.size();
    }

    public ExampleAdapter(List<Product> products, Activity context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Product product = products.get(position);

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_shopping_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.getProductTextView().setText(product.getName());
        holder.getProductImageView(). setImageResource(product.getPicture());

        return convertView;
    }

    private class ViewHolder {
        private final TextView productTextView;
        private final ImageView productImageView;

        private ViewHolder(View wrapperView) {
            productTextView = (TextView) wrapperView.findViewById(R.id.tvName);
            productImageView = (ImageView) wrapperView.findViewById(R.id.ivPicture);

        }

        public TextView getProductTextView() {
            return productTextView;
        }

        public ImageView getProductImageView() {
            return productImageView;
        }

    }

    private class Product {
        public int getName() {
            return 0;
        }

        public int getPicture() {
            return 0;
        }
    }
}