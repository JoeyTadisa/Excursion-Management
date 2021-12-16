package com.teamfive.thuexcursionapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Patrik Hanzséros
 * ExcursionEntry class, implementing Parcelable
 */

public class ExcursionEntry  implements Parcelable {

    /**
     * Variables:
     */
    public String description;
    public int maxParticipants;
    public String regDeadline;
    public String deregDeadline;
    public String meetingDetails;
    public String title;
    public String dateOfExcursion;
    public String destination;
    public double fee;
    public int id;


    /**
     * Constructor
     */
    public ExcursionEntry(String description, int maxParticipants, String regDeadline,
                          String deregDeadline, String meetingDetails, String title,
                          String dateOfExcursion, String destination, double fee, int id){
        this.description = description;
        this.maxParticipants = maxParticipants;
        this.regDeadline = regDeadline;
        this.deregDeadline = deregDeadline;
        this.meetingDetails = meetingDetails;
        this.title = title;
        this.dateOfExcursion = dateOfExcursion;
        this.destination = destination;
        this.fee = fee;
        this.id = id;
    }

    /**
     * Constructor
     * @param in We can retrieve the values that we originally wrote into 'Parcel'
     */
    protected ExcursionEntry(Parcel in) {
        description = in.readString();
        maxParticipants = in.readInt();
        regDeadline = in.readString();
        deregDeadline = in.readString();
        meetingDetails = in.readString();
        title = in.readString();
        dateOfExcursion = in.readString();
        destination = in.readString();
        fee = in.readDouble();
        id = in.readInt();
    }



    /**
     * Call second constructor with parcel
     */
    public static final Creator<ExcursionEntry> CREATOR = new Creator<ExcursionEntry>() {
        @Override
        public ExcursionEntry createFromParcel(Parcel in) {
            return new ExcursionEntry(in);
        }

        /**
         * @param size size of array
         * @return create array of ExcursionEntry type with appropriate size
         */
        @Override
        public ExcursionEntry[] newArray(int size) {
            return new ExcursionEntry[size];
        }
    };


    /**
     * Get description of selected excursion
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get maximum participants of selected excursion
     * @return maxParticipants
     */
    public int getMaxParticipants(){
        return maxParticipants;
    }

    /**
     * Get registration deadline of selected excursion
     * @return regDeadline
     */
    public String getRegDeadline(){
        return regDeadline;
    }

    /**
     * Get deregistration deadline of selected excursion
     * @return deregDeadline
     */
    public String getDeregDeadline(){
        return deregDeadline;
    }

    /**
     * Get meeting details of selected excursion
     * @return meetingDetails
     */
    public String getMeetingDetails(){
        return meetingDetails;
    }

    /**
     * Get title of selected excursion
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get date of selected excursion
     * @return dateOfExcursion
     */
    public String getDateOfExcursion(){
        return dateOfExcursion;
    }

    /**
     * Get destination of selected excursion
     * @return destination
     */
    public String getDestination(){
        return destination;
    }

    /**
     * Get the fee of selected excursion
     * @return fee
     */
    public Double getFee(){
        return fee;
    }


    /**
     * Get id of excursion
     * @return id
     */
    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * When we launch the destination Activity, our object will be written to a Parcel using this method
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
        parcel.writeInt(maxParticipants);
        parcel.writeString(regDeadline);
        parcel.writeString(deregDeadline);
        parcel.writeString(meetingDetails);
        parcel.writeString(title);
        parcel.writeString(dateOfExcursion);
        parcel.writeString(destination);
        parcel.writeDouble(fee);
        parcel.writeInt(id);
    }

}
