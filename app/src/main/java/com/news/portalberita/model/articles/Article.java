package com.news.portalberita.model.articles;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable{

    /**
     * source : {"id":"bbc-news","name":"BBC News"}
     * author : BBC News
     * title : EU negotiator: High risk of UK crashing out
     * description : The EU's deputy chief negotiator says it is a challenge to see how a deal could be backed by MPs
     * url : http://www.bbc.co.uk/news/uk-politics-47024450
     * urlToImage : https://ichef.bbci.co.uk/news/1024/branded_news/AA9C/production/_105367634_2bd30652-572c-498e-ad47-afcc0e33c812.jpg
     * publishedAt : 2019-01-28T15:52:41Z
     * content : Image copyrightEPA
     There is a high risk of the UK crashing out of the EU without a deal by accident, the EU's deputy chief negotiator Sabine Weyand has said.
     She said there remained "full ownership of what was agreed" on the EU's side, but "no ownership" of… [+7950 chars]
     */

    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    protected Article(Parcel in) {
        source = in.readParcelable(Source.class.getClassLoader());
        author = in.readString();
        title = in.readString();
        description = in.readString();
        url = in.readString();
        urlToImage = in.readString();
        publishedAt = in.readString();
        content = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(source, flags);
        dest.writeString(author);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(urlToImage);
        dest.writeString(publishedAt);
        dest.writeString(content);
    }
}
