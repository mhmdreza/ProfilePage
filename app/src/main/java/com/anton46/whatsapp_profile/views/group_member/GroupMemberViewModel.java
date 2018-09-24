package com.anton46.whatsapp_profile.views.group_member;


import com.anton46.whatsapp_profile.views.media.MediaViewModel;

public class GroupMemberViewModel {
    private String name;
    private String lastSeen;
    private MediaViewModel profilePicture;
    private boolean isAdmin;

    public GroupMemberViewModel(String name, String lastSeen, MediaViewModel profilePicture, boolean isAdmin) {
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

    public MediaViewModel getProfilePicture() {
        return profilePicture;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
