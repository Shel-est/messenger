package com.example.messenger.domain;

public final class Views {
    public interface Id {}

    public interface IdName extends Id {}

    public interface FullComment extends IdName {}

    public interface FullMessage extends IdName {}

    public interface FullPost extends IdName {}

    public interface FullProfile extends IdName {}

    public interface FullPublic extends IdName {}
}
