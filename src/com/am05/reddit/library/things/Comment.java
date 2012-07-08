package com.am05.reddit.library.things;

public class Comment extends UserSubmittedContent {
    private String linkId;
    private String parentId;
    private Listing<Comment> replies;

    public Comment() {
    }

    public String getLinkId() {
        return linkId;
    }

    @Override
    public String toString() {
        return "Comment [getUpvotes()=" + getUpvotes() + "\n getDownvotes()=" + getDownvotes()
                + "\n getAuthor()=" + getAuthor() + "\n getBody()=" + getBody() + "\n getName()="
                + getName() + "\nreplies=" + getReplies() + "]";
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public Kind getKind() {
        return Kind.THREAD;
    }

    public Listing<Comment> getReplies() {
        return replies;
    }

    public void setReplies(Listing<Comment> replies) {
        this.replies = replies;
    }
}