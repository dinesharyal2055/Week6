package com.dinesharyal.softuserclone.model

import android.os.Parcel
import android.os.Parcelable

data class student(
        val studentName:String?=null,
        val studentAge:String?=null,
        val studentGender:String?=null,
        val studentAddress:String?=null,
        val imageLink:String?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(studentName)
        parcel.writeString(studentAge)
        parcel.writeString(studentGender)
        parcel.writeString(studentAddress)
        parcel.writeString(imageLink)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<student> {
        override fun createFromParcel(parcel: Parcel): student {
            return student(parcel)
        }

        override fun newArray(size: Int): Array<student?> {
            return arrayOfNulls(size)
        }
    }
}
