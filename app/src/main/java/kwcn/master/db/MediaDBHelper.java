package kwcn.master.db;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import kwcn.master.entity.Music;

/**
 * Created by Administrator on 2018/8/19.
 */

public class MediaDBHelper {
    public final static Uri MEDIA_URI = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

    public final static Uri ALBUM_URI = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;

    public static List<Music> getMusicInfoAll(Context context) {
        String projection[] = {MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.TITLE, MediaStore
                .Audio.Media.ARTIST_ID, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media
                .ALBUM_ID, MediaStore.Audio.Media.ALBUM};
        try (Cursor c = context.getContentResolver().query(MEDIA_URI, projection, null, null,
                null, null)) {
            if (c != null && c.moveToFirst()) {
                List<Music> list = new ArrayList<>();
                do {
                    String albumId = c.getString(6);
                    Music music = new Music(c.getString(0), c.getString(1), c.getString(2), c
                            .getString(3), c.getString(4), c.getString(5), albumId, c.getString
                            (7), getAlbumArt(context, albumId));
                    list.add(music);
                } while (c.moveToNext());
                return list;
            }
        }
        return null;
    }

    @Nullable
    private static String getAlbumArt(Context context, @NonNull String albumId) {
        String projection[] = {MediaStore.Audio.AlbumColumns.ALBUM_ART};
        String selection = MediaStore.Audio.Albums._ID + "=" + albumId;
        try (Cursor c = context.getContentResolver().query(ALBUM_URI, projection, selection,
                null, null, null)) {
            if (c != null && c.moveToFirst()) {
                return c.getString(0);
            }
        }
        return null;
    }
}
