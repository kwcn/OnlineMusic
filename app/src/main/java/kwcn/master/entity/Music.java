package kwcn.master.entity;


import android.provider.MediaStore;


/**
 * Created by Administrator on 2018/8/19.
 */

public class Music implements MediaStore.MediaColumns {
    public final String mMediaId;
    public final String mPath;
    public final String mDisplayName;
    public final String mTitle;
    public final String mArtistId;
    public final String mArtist;
    public final String mAlbumId;
    public final String mAlbum;
    public final String mAlbumArt;

    public Music(String mMediaId, String mPath, String mDisplayName, String mTitle, String
            mArtistId, String mArtist, String mAlbumId, String mAlbum, String mAlbumArt) {
        this.mMediaId = mMediaId;
        this.mPath = mPath;
        this.mDisplayName = mDisplayName;
        this.mTitle = mTitle;
        this.mArtistId = mArtistId;
        this.mArtist = mArtist;
        this.mAlbumId = mAlbumId;
        this.mAlbum = mAlbum;
        this.mAlbumArt = mAlbumArt;
    }

    @Override
    public String toString() {
        return "mMediaId:[" + mMediaId + "] " + "mPath:[" + mPath + "] " + "mDisplayName:[" +
                mDisplayName + "] " + "mTitle:[" + mTitle + "] " + "mArtistId:[" + mArtistId + "]" +
                " " + "mArtist:[" + mArtist + "] " + "mAlbumId:[" + mAlbumId + "] " + "mAlbum:["
                + mAlbum + "] " + "mAlbumArt:[" + mAlbumArt + "]";
    }
}
