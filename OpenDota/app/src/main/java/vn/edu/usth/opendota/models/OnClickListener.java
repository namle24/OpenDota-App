package vn.edu.usth.opendota.models;

import vn.edu.usth.opendota.matches.Matches;

public interface OnClickListener {
    void onClick(int position, Matches match);
}