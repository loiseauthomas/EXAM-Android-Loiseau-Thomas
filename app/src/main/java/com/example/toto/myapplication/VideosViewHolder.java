package com.example.toto.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class VideosViewHolder extends RecyclerView.ViewHolder {
    public static final Video VIDEO = null;
    //private ImageView image;
    private TextView title;
    private TextView publication_date;
    private TextView author;
    private OnVideoSelectedListener onVideoSelectedListener;

    public VideosViewHolder(View itemView) {
        super(itemView);
        //image = (ImageView) itemView.findViewById(imageView);
        title = (TextView) itemView.findViewById(R.id.title);
        publication_date = (TextView) itemView.findViewById(R.id.publicationDate);
        author = (TextView) itemView.findViewById(R.id.author);
    }

    public void bind(final Video video) {
        String url=video.getUrl();
        /*Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        image.setImageBitmap(bitmap);*/


        title.setText(video.getTitle());
        publication_date.setText(video.getPublishedAt());
        author.setText(video.getChannelTitle());
        // + thumbnail
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onVideoSelectedListener == null) {
                    return;
                }
                onVideoSelectedListener.onVideoSelected(video);
            }
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
