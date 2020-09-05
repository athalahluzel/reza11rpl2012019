package com.example.reza11rpl2012019;

public class model {

    String original_title;
    String release_date;
    String poster_path;
    Boolean Adult;
    String Overviw;
    int vote_count;

    public String getOriginal_title(){
        return original_title;
    }

    public void setOriginal_title(String original_title){
        this.original_title = original_title;
    }

    public String getRelease_date(){
        return release_date;
    }

    public void setRelease_date(String release_date){
        this.release_date = release_date;
    }

    public String getPoster_path(){
        return poster_path;
    }

    public void setPoster_path(String poster_path){
        this.poster_path = poster_path;
    }

    public Boolean getAdult(){
        return Adult;
    }

    public void setAdult(Boolean adult){
        this.Adult = adult;
    }

    public String getOverviw() {
        return Overviw;
    }

    public void setOverviw(String overviw) {
        this.Overviw = overviw;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
