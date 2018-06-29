package com.sixthsense.android.domain.repository.onboard;

import android.os.Parcel;
import android.os.Parcelable;

public class SignUpRequestBean implements Parcelable{


    protected SignUpRequestBean(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SignUpRequestBean> CREATOR = new Creator<SignUpRequestBean>() {
        @Override
        public SignUpRequestBean createFromParcel(Parcel in) {
            return new SignUpRequestBean(in);
        }

        @Override
        public SignUpRequestBean[] newArray(int size) {
            return new SignUpRequestBean[size];
        }
    };
}
