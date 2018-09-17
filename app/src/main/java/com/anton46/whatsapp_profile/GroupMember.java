package com.anton46.whatsapp_profile;

import android.support.design.widget.FloatingActionButton;

public class GroupMember {
    private String name;
    private String lastSeen;
    private Media profilePicture;
    private boolean isAdmin;

    public GroupMember(String name, String lastSeen, Media profilePicture, boolean isAdmin) {
        this.name = name;
        this.lastSeen = lastSeen;
        this.profilePicture = profilePicture;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public Media getProfilePicture() {
        return profilePicture;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
