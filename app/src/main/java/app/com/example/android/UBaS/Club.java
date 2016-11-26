package app.com.example.android.UBaS;

import static android.R.attr.name;

/**
 * Created by MandipSilwal on 11/25/16.
 */

public class Club {

    public String name;
    public Boolean isMember;

    public Club(String clubName, Boolean isMember) {

        this.name = clubName;
        this.isMember = isMember;

    }
}
