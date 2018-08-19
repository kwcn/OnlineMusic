package kwcn.master.util;

import android.util.Log;

import java.util.List;

import kwcn.master.entity.Music;

/**
 * Created by Administrator on 2018/8/19.
 */

public class k {
    private static final String TAG = "kwdy";

    public static void d(String s) {
        Log.d(TAG, s);
    }

    public static void dMusicList(List<Music> list) {
        if (list == null || list.size() <= 0) {
            d("musicList is null");
            return;
        }
        for (Music music : list) {
            d(music.toString());
        }
    }
}
