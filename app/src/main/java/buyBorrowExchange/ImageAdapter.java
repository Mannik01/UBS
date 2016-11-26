package buyBorrowExchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import app.com.example.android.UBaS.R;

/**
 * Created by MandipSilwal on 11/16/16.
 */

public class ImageAdapter extends BaseAdapter{

    private Context c;
    private int[] imageId;

    public ImageAdapter(Context context, int[] ids) {
        this.c = context;
        imageId = ids;
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {

        return imageId[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//     Class created for optimization purpose
    class ViewHolder{

        ImageView iView;
        ViewHolder(ImageView img) {
            iView = img;
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = (ImageView) convertView;
        ViewHolder holder = null;

        if(imageView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            imageView = (ImageView) inflater.inflate(R.layout.grid_item,parent,false);
            holder = new ViewHolder(imageView);
            imageView.setTag(holder);
        }
        else {
            holder = (ViewHolder) imageView.getTag();
        }
        holder.iView.setImageResource(imageId[0]); // set images from the database

        return imageView;
    }
}
