package com.huda.submission_2_made

import android.os.Parcel
import android.os.Parcelable


data class RootData(
    var name: String?,
    var description: String?,
    var photo: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RootData> {
        override fun createFromParcel(parcel: Parcel): RootData {
            return RootData(parcel)
        }

        override fun newArray(size: Int): Array<RootData?> {
            return arrayOfNulls(size)
        }
    }
}