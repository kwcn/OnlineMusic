package kwcn.master.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kwcn.master.entity.Music;
import kwcn.master.myapplication.R;

/**
 * Created by Administrator on 2018/8/19.
 */

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {

    private Context mContext;

    private List<Music> mMusicList;

    public BaseAdapter(List<Music> list, Context context) {
        mMusicList = list;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout
                .item_base, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Music music = mMusicList.get(position);
        holder.mTxt1.setText(music.mTitle);
        holder.mTxt2.setText(music.mArtist);

        Bitmap bm = BitmapFactory.decodeFile(music.mAlbumArt);
        BitmapDrawable bmpDraw = new BitmapDrawable(bm);
        holder.mImg.setImageDrawable(bmpDraw);
    }

    @Override
    public int getItemCount() {
        return mMusicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTxt1;

        private TextView mTxt2;

        private ImageView mImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mTxt1 = itemView.findViewById(R.id.txt1);
            mTxt2 = itemView.findViewById(R.id.txt2);
            mImg = itemView.findViewById(R.id.img);
        }
    }
}
