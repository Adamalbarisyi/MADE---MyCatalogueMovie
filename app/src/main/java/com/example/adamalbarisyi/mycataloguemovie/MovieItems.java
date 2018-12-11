package com.example.adamalbarisyi.mycataloguemovie;

import org.json.JSONException;
import org.json.JSONObject;

class MovieItems {
    private int id;
    private String backDropPath;
    private String Title;
    private String oriTitle;
    private String oriLanguage;
    private String Vote;
    private String Rating;
    private String ReleaseDate;
    private String Overview;
    private String posterPath;


    public MovieItems(JSONObject object){
        try {
            int id = object.getInt("id");
            String backDropPath = object.getString("backdrop_path");
            String Title = object.getString("title");
            String oriTitle = object.getString("original_title");
            String oriLanguage = object.getString("original_language");
            String Vote = object.getString("vote_count");
            String Rating = object.getString("vote_average");
            String ReleaseDate = object.getString("release_date");
            String Overview = object.getString("overview");
            String posterPath = object.getString("poster_path");

            this.id =id;
            this.Title = Title;
            this.oriTitle = oriTitle;
            this.oriLanguage = oriLanguage;
            this.Vote = Vote;
            this.Rating = Rating;
            this.ReleaseDate = ReleaseDate;
            this.Overview = Overview;
            this.posterPath = posterPath;
            this.backDropPath = backDropPath;

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getOriTitle() {
        return oriTitle;
    }

    public void setOriTitle(String oriTitle) {
        this.oriTitle = oriTitle;
    }

    public String getOriLanguage() {
        return oriLanguage;
    }

    public void setOriLanguage(String oriLanguage) {
        this.oriLanguage = oriLanguage;
    }

    public String getVote() {
        return Vote;
    }

    public void setVote(String vote) {
        Vote = vote;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        this.backDropPath = backDropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
