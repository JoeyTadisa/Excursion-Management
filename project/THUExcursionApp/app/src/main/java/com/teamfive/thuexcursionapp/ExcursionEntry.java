package com.teamfive.thuexcursionapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ExcursionEntry  implements Parcelable {
    public String description;
    //public String dateAdded;
    public int maxParticipants;
    public String regDeadline;
    public String deregDeadline;
    public String meetingDetails;
    public String title;
    public String dateOfExcursion;

    public ExcursionEntry(String description, int maxParticipants, String regDeadline,
                          String deregDeadline, String meetingDetails, String title, String dateOfExcursion){
        this.description = description;
        this.maxParticipants = maxParticipants;
        this.regDeadline = regDeadline;
        this.deregDeadline = deregDeadline;
        this.meetingDetails = meetingDetails;
        this.title = title;
        this.dateOfExcursion = dateOfExcursion;
    }

    protected ExcursionEntry(Parcel in) {
        description = in.readString();
        maxParticipants = in.readInt();
        regDeadline = in.readString();
        deregDeadline = in.readString();
        meetingDetails = in.readString();
        title = in.readString();
        dateOfExcursion = in.readString();
    }

    public static final Creator<ExcursionEntry> CREATOR = new Creator<ExcursionEntry>() {
        @Override
        public ExcursionEntry createFromParcel(Parcel in) {
            return new ExcursionEntry(in);
        }

        @Override
        public ExcursionEntry[] newArray(int size) {
            return new ExcursionEntry[size];
        }
    };


    public String getDescription() {
        return description;
    }

    public int getMaxParticipants(){
        return maxParticipants;
    }

    public String getRegDeadline(){
        return regDeadline;
    }

    public String getDeregDeadline(){
        return deregDeadline;
    }

    public String getMeetingDetails(){
        return meetingDetails;
    }

    public String getTitle() {
        return title;
    }

    public String getDateOfExcursion(){ return dateOfExcursion; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
        parcel.writeInt(maxParticipants);
        parcel.writeString(regDeadline);
        parcel.writeString(deregDeadline);
        parcel.writeString(meetingDetails);
        parcel.writeString(title);
        parcel.writeString(dateOfExcursion);
    }

    //Date dateAdded, int maxParticipants, Date regDeadline,
//Date deregDeadline, String meetingDetails,

}
