package com.litziy.kawalcovid.ui.home


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("http_response")
    val httpResponse: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("message_id")
    val messageId: String,
    @SerializedName("news")
    val news: ArrayList<New>,
    @SerializedName("size")
    val size: Int,
    @SerializedName("status")
    val status: Int
) {
    data class New(
        @SerializedName("author")
        val author: String,
        @SerializedName("content")
        val content: String,
        @SerializedName("cover_link")
        val coverLink: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("further_link")
        val furtherLink: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("updated_at")
        val updatedAt: String
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readInt(),
                parcel.readString().toString(),
                parcel.readString().toString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(author)
            parcel.writeString(content)
            parcel.writeString(coverLink)
            parcel.writeString(createdAt)
            parcel.writeString(furtherLink)
            parcel.writeInt(id)
            parcel.writeString(title)
            parcel.writeString(updatedAt)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<New> {
            override fun createFromParcel(parcel: Parcel): New {
                return New(parcel)
            }

            override fun newArray(size: Int): Array<New?> {
                return arrayOfNulls(size)
            }
        }
    }
}